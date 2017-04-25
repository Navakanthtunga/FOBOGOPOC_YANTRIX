$(document).ready(function(){
    
    var paramValue = getUrlParameter('arg');
    if(paramValue=='current'){
        if($('body.index').length>0){
            $('#total-fail').attr("onclick","window.open('failures.html?arg=current','mywindow');");
        }
        generateReport("../results_archive/current");
        generateFailureReport("../results_archive/current");
    }
    else{
        if($('body.index').length>0){
            $('#total-fail').attr("onclick","window.open('failures.html?arg="+paramValue+"','mywindow');");
        }
        generateReport("../results_archive/"+paramValue);
        generateFailureReport("../results_archive/"+paramValue);
    }
    if($('body.build-history').length>0){
        jQuery.get('../results_archive/foldernames.txt', function(data) {
            $('<table id="datatable" data-graph-container-before="1" data-graph-type="column" data-graph-datalabels-enabled="1" border="0" cellspacing="1" cellpadding="0" data-graph-margin-bottom="100"><caption>Build History</caption><thead><tr><th data-graph-stack-group="1">Build Date</th><th data-graph-stack-group="1">Pass</th><th data-graph-stack-group="1">Fail</th><th data-graph-stack-group="1">Skip</th></tr></thead><tbody></tbody></table>').appendTo($('#data'));            
            $('<table id="tableone" border="0" cellspacing="1" cellpadding="0"><thead><tr><th>Total</th></tr></thead><tbody></tbody><table>').appendTo($('#data'));
            var folderNames = data.split(",");
            for (i=0;i<folderNames.length;i++){
                if(folderNames[i]!="current"){
                    returnStats(folderNames[i],"../results_archive/"+folderNames[i]);
                }                                
            }
            setTimeout(function() {                
                $('table#datatable').bind('highchartTable.beforeRender', function(event, highChartConfig) {
                    highChartConfig.colors = ['#669900', '#CC0000', '#FFFF66'];
                }).highchartTable();
                
                //Click function to take users to reports page
                $('.build-name').each(function(i){
                    $(this).attr("onclick","window.open('result.html?arg="+$(this).text()+"','resultwindow');");
                });                
            }, 1000);       
        },'text');       
    }
});

function returnStats(folderName,folderPath){
    jQuery.get(folderPath+'/results.txt', function(data) {
        //console.log(data);
        xml = $.parseXML(data);
        var totalScripts = $(xml).find('testng-results').attr("total");
        var totalPass = $(xml).find('testng-results').attr("passed");
        var totalFailed = $(xml).find('testng-results').attr("failed");
        var totalSkipped = $(xml).find('testng-results').attr("skipped");
        $('<tr><td class="build-name">'+folderName+'</td><td>'+totalPass+'</td><td>'+totalFailed+'</td><td>'+totalSkipped+'</td></tr>').appendTo('#datatable tbody');
        $('<tr><td>'+totalScripts+'</td></tr>').appendTo('#tableone tbody');
    },'text');
}

function generateReport(folderPath){
    jQuery.get(folderPath+'/results.txt', function(data) {
        //console.log(data);
        xml = $.parseXML(data);
        var suiteName = $(xml).find('suite').attr('name');
        var startDate = $(xml).find('suite').attr('started-at');
        var finishDate = $(xml).find('suite').attr('finished-at');
        var totalTime = (parseInt($(xml).find('suite').attr('duration-ms'))/60000).toFixed(3);

        var totalScripts = $(xml).find('testng-results').attr("total");
        var totalPass = $(xml).find('testng-results').attr("passed");
        var totalFailed = $(xml).find('testng-results').attr("failed");
        var totalSkipped = $(xml).find('testng-results').attr("skipped");        
        $('.suite-name').text("Regression Suite Name: "+suiteName);
        $('.start-date').text("Execution Started at: "+startDate.split("T")[0]+" "+startDate.split("T")[1].slice(0,-1));
        $('.finish-date').text("Execution Ended at: "+finishDate.split("T")[0]+" "+finishDate.split("T")[1].slice(0,-1));

        $('#total-scripts .val').text(totalScripts);
        $('#total-pass .val').text(totalPass);
        $('#total-fail .val').text(totalFailed);
        $('#total-skip .val').text(totalSkipped);
        $('#total-time .val').text(totalTime+" Mins");
        if(parseInt(totalFailed)>0){
            $('body.index #total-fail').css('background','red');
        }
        var maxTime=0;
        var scriptName="";
        var timeVal = [];            
        $(xml).find('class').each(function(i){
            var className=$(this);
            var timeValue=0;
            className.find('test-method').each(function(){
                timeValue = timeValue+parseInt($(this).attr('duration-ms'));    
            });           
            timeVal[i]=parseFloat((timeValue/1000).toFixed(3));
            if(timeVal[i] > maxTime){
                maxTime = timeVal[i];
                var nm = $(this).attr("name").split(".")
                scriptName=nm[nm.length-1];
            }
        });        
        generateSummaryGraph(parseInt(totalPass),parseInt(totalFailed),parseInt(totalSkipped));
        generateTimeGraph(timeVal);
        
        $('#stats #avg-execution-time .val').text((totalTime/parseInt(totalScripts)).toFixed(3)+" Seconds");
        $('#stats #max-execution-time .val').text(maxTime+" Seconds");
        $('#stats #max-script-name .val').text(scriptName);
    
    },'text');
    
    jQuery.get(folderPath+'/basicinfo.txt', function(basic) {        
        
        var browser = basic.split(",")[0];
        var version = basic.split(",")[1];
        var os = basic.split(",")[2];
        
        $('#browser .val').text(browser);
        $('#version .val').text(version);
        $('#os .val').text(os);
    },'text');   
}
function generateFailureReport(folderPath){
    jQuery.get(folderPath+'/results.txt', function(data) {
        //console.log(data);
        xml = $.parseXML(data);
                
        $(xml).find('class').each(function(i){
            var className=$(this);
            className.find('test-method').each(function(){                
                if($(this).attr('status')=='FAIL'){
                    var nm = className.attr("name").split(".")
                    var scriptName=nm[nm.length-1];
                    var imgSrc = folderPath+"/screenshots/"+scriptName+".jpg";
                    var errorInfo = $(this).find('full-stacktrace').text();
                    var errorLineInfo="";
                    var exceptionArr = errorInfo.split(":");
                    var ExceptionMsg = exceptionArr[0]+" "+exceptionArr[1];
                    var exceptionArrInfo = errorInfo.split("\n");
                    for(var i=0;i<exceptionArrInfo.length;i++){
                        //console.log(exceptionArrInfo[i]);
                        if(exceptionArrInfo[i].indexOf('at sun.reflect')>0){
                            errorLineInfo=exceptionArrInfo[i-1];
                            break;   
                        }
                    }
                    console.log(ExceptionMsg);
                    console.log(errorLineInfo);
                    $('#left-column').append($('<div class="name">'+scriptName+'</div>'));                             
                    $('#right-column').append($('<div class="error"><div class="error-summary">'+ExceptionMsg+'\n'+errorLineInfo+'</div><div class="view-full">Click here to view full stack trace</div><div class="msg">'+errorInfo+'</div><div class="screenshot"><img src="'+imgSrc+'"/></div></div>'));       
                }
            });                      
        });  
        
        $('.error').eq(0).css('display','block');
        
        $('.name').click(function(){
            var tcNum = $(this).index();
            $('.error').css('display','none');
            $('.error').eq(tcNum-1).css('display','block');
        });
        
        $('.view-full').click(function(){
            $(this).next().slideToggle(500);
        });
    },'text'); 
}
function generateSummaryGraph(pass,fail,skip){
    $('#summary-graph').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 35,
                beta: 0
            }
        },
        title: {
            text: 'Automation Execution Summary Report'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Execution Summary Report',
            data: [
                {
                    name:'PASS',
                    y: pass,
                    color:'#008F00'
                },
                {
                    name: 'Fail',
                    y: fail,
                    sliced: true,
                    color:'#FF2600',
                    selected: true                    
                },
                {
                    name:'Skip',
                    y: skip,
                    color:'#FFFF00'
                }
            ]
        }]
    });
}

function generateTimeGraph(dataVal){
    $('#time-graph').highcharts({
        chart: {
            type: 'line',
            zoomType: 'x'
        },
        title: {
            text: 'Script Execution Time Graph'
        },   
        subtitle: {
            text: 'Represents execution time for each script as a point. This helps in picking out the max script time'
        },
        yAxis: {
            title: {
                text: 'Time in Seconds'
            }
        },
        
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: [{
            name: 'Execution Time',
            color:'#376092',
            data: dataVal
        }]
    });
}

function getUrlParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}         