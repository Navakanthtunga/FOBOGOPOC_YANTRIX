package generic_lib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptLibrary {
	
	public void mouseHoverByJavascriptExecutor(WebDriver driver,String locatorType, String locatorValue ){
		WebElement element=null;
		if(locatorType.equals("id")){
			element=driver.findElement(By.id(locatorValue));
		}
		else if(locatorType.equals("name")){
			element=driver.findElement(By.name(locatorValue));
		}
		else if(locatorType.equals("linkText")){
			element=driver.findElement(By.linkText(locatorValue));
		}
		else if(locatorType.equals("className")){
			element=driver.findElement(By.className(locatorValue));
		}
		else if(locatorType.equals("xpath")){
			element=driver.findElement(By.xpath(locatorValue));
		}
		else if(locatorType.equals("cssSelector")){
			element=driver.findElement(By.cssSelector(locatorValue));
		}
		else if(locatorType.equals("tagName")){
			element=driver.findElement(By.tagName(locatorValue));
		}
		else if(locatorType.equals("partialLinkText")){
			element=driver.findElement(By.partialLinkText(locatorValue));
		}
		else{
			System.out.println("Wrong locator type");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    String strJavaScript = "var element = arguments[0];"
	            + "var mouseEventObj = document.createEvent('MouseEvents');"
	            + "mouseEventObj.initEvent( 'mouseover', true, true );"
	            + "element.dispatchEvent(mouseEventObj);";
	    js.executeScript(strJavaScript, element); 
	}
}
