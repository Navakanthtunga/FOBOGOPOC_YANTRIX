package generic_lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Library {
	public void verifyElementPresent(WebDriver driver, String locatorType, String locatorValue){
		WebElement element = null;
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
		Assert.assertEquals(element.isDisplayed(), true);
		
	}
	public WebElement getElement(WebDriver driver, String locatorType,String locatorValue){
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
		return element;
	}
	public void clickOnElement(WebDriver driver, String locatorType,String locatorValue){
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
		element.click();
	}
	public void clearData(WebDriver driver, String locatorType,String locatorValue){
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
		element.clear();
	}
	public void sendData(WebDriver driver, String locatorType,String locatorValue, String testData){
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
		element.sendKeys(testData);
	}
	public void clickOnDropdownByVisibleText(WebDriver driver, String locatorType,String locatorValue, String visibleText){
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
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}
	public void clickOnDropdownByValue(WebDriver driver, String locatorType,String locatorValue, String value){
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
		Select select=new Select(element);
		select.selectByValue(value);
	}
}
