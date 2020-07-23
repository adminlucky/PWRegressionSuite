package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.UtilityMethods;

public class EmailTenants extends TestBase {
	
	
	public static WebElement emailTenants(){
		return driver.findElement(By.xpath("//a[contains(text(),'Email All Tenants')]"));
	}
	
	public static void selectmultipleTenants(){
		for(int i=1; i<6; i++)
		{
			
			try {
				String tenants = "//tr[" +i +"]//td[1]//input[1]";
				driver.findElement(By.xpath(tenants)).click();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	public static WebElement email(){
		return driver.findElement(By.xpath("//div[7]//input[1]"));
	}
	
	public static void emailTemplate(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id("emailTemplateIDAsString")));
		(new Select(driver.findElement(By.id("emailTemplateIDAsString")))).selectByIndex(4);
		
	}
	
	public static WebElement attachFilesB(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id("showAttachmentsFormButton")));
		return driver.findElement(By.id("showAttachmentsFormButton"));
	}
	public static WebElement file(){
		return driver.findElement(By.xpath("//input[@name='file(1)']"));
	}
	public static void subjectTemplate(){
		(new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
             WebElement el = driver.findElement(By.id("email.subject"));
             String value = el.getAttribute("value");
             if(value.length() != 0 ) {
                return true;
             }
             else
            	 return false;
          }
		});
		//return driver.findElement(By.xpath("//input[@id='email.subject']"));
	}
	public static void bodyTemplate(){
		driver.switchTo().frame("mce_editor_0");
		(new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
             WebElement el = driver.findElement(By.xpath("//body[@class='mceContentBody']"));
             String value = el.getText();
             if(value.length() != 0 ) {
            	return true;
             }
             else
            	 return false;
          }
		});
		
		//return driver.findElement(By.xpath("/html[1]/body[1]/p[2]"));
	}
	public static void send(){
		driver.findElement(By.xpath("//input[@value='Send']")).click();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='emailFormContainer']")));
	}
	
	public static void selectMultipleLeases(){
		for( int i=1; i<2; i++){
			driver.findElement(By.xpath("(//input[starts-with(@id,'lease_')])["+ i +"]")).click();
		}	
	}
	
	public static WebElement emailButton(){
		return driver.findElement(By.xpath("//div[@class='primaryButtons']//input[4]"));
	}
	
	public static WebElement subject(){
		(new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
             WebElement el = driver.findElement(By.id("email.subject"));
             String value = el.getAttribute("value");
             if(value.length() != 0 ) {
                return true;
             }
             else
            	 return false;
          }
		});
		return driver.findElement(By.xpath("//input[@id='email.subject']"));
	}
	public static void emailBody(){
		System.out.println("Entered emailBody()");
		driver.switchTo().frame("mce_editor_0");
		System.out.println("Switched to Iframe");
		(new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
             WebElement el = driver.findElement(By.xpath("//body[@class='mceContentBody']"));
             String value = el.getText();
             if(value.length() != 0 ) {
            	System.out.println("Body length: "+value.length());
                return true;
             }
             else
            	 return false;
          }
		});
		System.out.println("Returning body WebElement");
		driver.findElement(By.xpath("//body[@class='mceContentBody']")).clear();
		//driver.findElement(By.xpath("//body[@class='mceContentBody']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		//driver.findElement(By.xpath("//body[@class='mceContentBody']")).sendKeys("Sample email body for tenant emails");
		driver.switchTo().parentFrame();
	}
	
		
	
	
	
}
