package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		(new Select(driver.findElement(By.id("emailTemplateIDAsString")))).selectByIndex(4);
		
	}
	
	public static WebElement attachFilesB(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id("showAttachmentsFormButton")));
		return driver.findElement(By.id("showAttachmentsFormButton"));
	}
	public static WebElement file(){
		return driver.findElement(By.xpath("//input[@name='file(1)']"));
	}
	public static WebElement body(){
		return driver.findElement(By.xpath("/html[1]/body[1]/p[2]"));
	}
	public static WebElement send(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Send']")));
		return driver.findElement(By.xpath("//input[@value='Send']"));
	}
	
	
	
	
}
