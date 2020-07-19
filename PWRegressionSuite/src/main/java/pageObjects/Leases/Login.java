package pageObjects.Leases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.UtilityMethods;

public class Login extends TestBase {
	
	public static void launchBrowser(){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
		return driver.findElement(By.xpath("//div[3]/div[2]/div[2]/ul[1]/li[1]/a[1]"));
		
	}
	public static void refreshPage() throws InterruptedException{
		driver.get("https://sat.propertyware.com/pw/leases/leases_home.do");
		//(new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div[2]/ul[1]/li[5]/a[1]")));
		
		/*try{
			if (driver.switchTo().alert() != null){
			driver.switchTo().alert().accept();
			}
		}
		catch (NoAlertPresentException Ex) 
		{ 
		        
		}*/
	}
		
}
