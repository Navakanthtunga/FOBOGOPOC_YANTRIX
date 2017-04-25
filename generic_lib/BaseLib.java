package generic_lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLib {
	public static WebDriver driver=null;
	@BeforeMethod
	public void launchBrowser(){
		System.setProperty("webdriver.gecko.driver",GenericLib.sDirPath+"\\exefiles\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	public static void loadUrl(String Url){
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	
}
