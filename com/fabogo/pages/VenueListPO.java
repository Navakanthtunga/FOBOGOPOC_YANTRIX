package com.fabogo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VenueListPO {
	WebDriver driver=null;

	public VenueListPO(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='mt5 bb bt pt10 pb10']//span")
	private WebElement eleSortByIcn;
	public WebElement getEleSortByIcn(){
		return eleSortByIcn;
	}
	@FindBy(xpath="//a[contains(text(),'The Little Hair Salon')]")
	private WebElement eleTheLittleHairSalonLnk;
	public WebElement getEleTheLittleHairSalonLnk(){
		return eleTheLittleHairSalonLnk; 
	}	
	@FindBy(xpath="//a[text()='VIEW ALL SERVICES']")
	private WebElement eleViewAllServicesLnk;
	public WebElement getEleViewAllServicesLnk(){
		return eleViewAllServicesLnk;
	}
	@FindBy(xpath="//div[text()=' PHONE NUMBER']")
	private WebElement elePhoneNumberBtn;
	public WebElement getElePhoneNumberBtn(){
		return elePhoneNumberBtn;
	}
	@FindBy(xpath="//p[text()='Prior bookings are recommended']")
	private WebElement elePhoneNumberInstructionTxt;
	public WebElement getElePhoneNumberInstructionTxt(){
		return elePhoneNumberInstructionTxt;
	}
	@FindBy(xpath="(//div[@classss='p15 bg-white pt5 border-radius-3 mb10 pb5']//span)[1]")
	private WebElement eleLadiesTxt;
	public WebElement getEleLadiesTxt(){
		return eleLadiesTxt;
	}
	@FindBy(xpath="(//span[contains(text(),'Economical')])[1]")
	private WebElement eleEconomicalTxt;
	public WebElement getEleEconomicalTxt(){
		return eleEconomicalTxt;
	}	
	
}
