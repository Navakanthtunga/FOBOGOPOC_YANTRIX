package com.fabogo.nail_services;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.testng.annotations.Test;

import generic_lib.BaseLib;
import generic_lib.GenericLib;
import generic_lib.JavaScriptLibrary;
import generic_lib.Library;

public class NailServicesTest extends BaseLib
{
Library library=null;
JavaScriptLibrary javaScriptLibrary=null;
@Test(priority=1,enabled=false,description="Search for a service, Click on a Venue, Verify PHONE NUMBER Button, Share Link, Your Rating and View All Services link.")
public void verify() throws Throwable{

	library=new Library();
	loadUrl("http://www.fabogo.com/");
	Thread.sleep(6000);
	// To verify Search Feild
	library.verifyElementPresent(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",1,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",1,3));
	// To Click Search Feild
	library.clickOnElement(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",1,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",1,3));
	Thread.sleep(3000);
	// To Select Option
	library.clickOnElement(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",2,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",2,3));
	// To click on Search Button
	library.clickOnElement(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",3,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",3,3));
	Thread.sleep(8000);
	// To click on Venue
	library.clickOnElement(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",4,2), GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",4,3));
	Thread.sleep(8000);
	// To Click on Phone number button
	library.clickOnElement(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",5,2), GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",5,3));
	Thread.sleep(2000);
	// To verify Prior bookings are recommended Text text
	library.verifyElementPresent(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",6,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",6,3));
	// To click on View All Services link
	library.clickOnElement(driver, GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",7,2), GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",7,3));
	Thread.sleep(2000);
	// To verify Hide Services Link
	library.verifyElementPresent(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",8,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",8,3));
	// To click on favorite icon
	library.clickOnElement(driver, GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",9,2), GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",9,3));
	// To verify Login button 
	library.verifyElementPresent(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",10,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",10,3));
	// To click on close icon
	library.clickOnElement(driver, GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",11,2), GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",11,3));
	//To click on Share button
	library.clickOnElement(driver, GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",12,2), GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",12,3));
	Thread.sleep(2000);
	// To verify Message in popup after clicking on the Share link 
	library.verifyElementPresent(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",13,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",13,3));
	// To click on Ok button
	library.clickOnElement(driver, GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",14,2), GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",14,3));
	// To click on Rating
	//javaScriptLibrary.mouseHoverByJavascriptExecutor(driver, GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",15,2), GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",15,3));
	Thread.sleep(2000);
	library.clickOnElement(driver, GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",15,2), GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",15,3));
	Thread.sleep(2000);
	// To verify Login button 
	library.verifyElementPresent(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",10,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",10,3));
	System.out.println("came to login page");
	// To click on close icon
	library.clickOnElement(driver, GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",11,2), GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_001",11,3));	
}
@Test(priority=2,enabled=true,description="Verification of Sponsered venues")
public void verifySponseredVenues() throws Throwable{

	library=new Library();
	loadUrl("http://www.fabogo.com/");
	Thread.sleep(6000);
	// To verify Search Feild
	library.verifyElementPresent(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_002",1,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_002",1,3));
	// To Click Search Feild
	library.clickOnElement(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_002",1,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_002",1,3));
	Thread.sleep(3000);
	// To Select Option
	library.clickOnElement(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_002",2,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_002",2,3));
	// To click on Search Button
	library.clickOnElement(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_002",3,2),GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_002",3,3));
	Thread.sleep(8000);
	// To click on Venue
	library.clickOnElement(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_002",4,2), GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_002",4,3));
	Thread.sleep(8000);
	// To click on Venue
	library.clickOnElement(driver,GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_002",5,2), GenericLib.toReadExcelData(GenericLib.testDataFilePath,"Tc_NS_002",5,3));
	Thread.sleep(8000);
	}
}
