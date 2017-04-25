package com.fabogo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePO {
	WebDriver driver=null;
	
	public HomePO(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
			
	@FindBy(id="search-selector")
	private WebElement eleSearchFld;
	public WebElement getEleSearchFld(){
		return eleSearchFld;
	}
	@FindBy(id="location-selector")
	private WebElement eleLocationFld;
	public WebElement getEleLocationFld(){
		return eleLocationFld;
	}
	@FindBy(id="search-bar-button")
	private WebElement eleSearchBtn;
	public WebElement getEleSearchBtn(){
		return eleSearchBtn;
	}
	@FindBy(xpath="//i[@class=' flaticon glyph-icon flaticon-women']")
	private WebElement nailServiceOpt;
	public WebElement getEleNailServiceOpt(){
		return nailServiceOpt;
	}
	@FindBy(xpath="//ul[@id='ui-id-2']//li[contains(@id,'ui-id-')]//a//div")
	private WebElement eleLocationSuggestionsTxt;
	public WebElement getEleLocationSuggestionsTxt(){
		return eleLocationSuggestionsTxt;
	}
}
