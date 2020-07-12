package pageObjects.Leases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import testBase.TestBase;
import utilities.UtilityMethods;

public class Login extends TestBase {
	
	public static void launchBrowser(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	public static WebElement username(){
		return driver.findElement(By.name("email"));
	}
	
	public static WebElement password(){
		return driver.findElement(By.name("password"));
	}
	
	public static WebElement signIn(){
		return driver.findElement(By.xpath("//*[@id=\"main-content\"]/aside/div/form/input[2]"));
	}
	public static WebElement homePage(){
		/*//UtilityMethods.waitForElementToBeClickable(driver, "//li[@id='current']//a[contains(text(),'Leases')]");
		
		try {
			return driver.findElement(By.xpath("//*[@id='current']/a"));
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			return driver.findElement(By.xpath("//*[@id='current']/a"));
		}*/
		
		return driver.findElement(By.xpath("//div[3]/div[2]/div[2]/ul[1]/li[1]/a[1]"));
		
	}
	public static void refreshPage() throws InterruptedException{
		UtilityMethods.waitForElementToLoad(driver, "//div[3]/div[2]/div[2]/ul[1]/li[1]/a[1]");
		driver.navigate().refresh();
		try{
			if (driver.switchTo().alert() != null){
			driver.switchTo().alert().accept();
			}
		}
		catch (NoAlertPresentException Ex) 
		{ 
		        
		}
	}
		
}
