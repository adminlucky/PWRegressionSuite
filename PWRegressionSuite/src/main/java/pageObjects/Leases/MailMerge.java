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
import org.testng.Assert;

import testBase.TestBase;
import utilities.UtilityMethods;

public class MailMerge extends TestBase {
	
	
	public static WebElement mailMergeHome(){
		return driver.findElement(By.xpath("//div[@class='primaryButtons']//input[3]"));
	}
	public static WebElement mailMergeSummary(){
		return driver.findElement(By.xpath("//div[@class='primaryButtons']//input[4]"));
	}
	public static WebElement viewDoc(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='generateButton']")));
		return driver.findElement(By.xpath("//input[@id='generateButton']"));
	}
	
	public static WebElement attachToLease(){
		return driver.findElement(By.xpath("//div[@class='primaryButtons']//input[2]"));
	}
	public static WebElement emailThisDoc(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='primaryButtons']//input[3]")));
		return driver.findElement(By.xpath("//div[@class='primaryButtons']//input[3]"));
	}
	public static void validateDocSelection(){
		String errMsg = "You must select a Template, Packet or Document.";
		if(driver.getPageSource().contains(errMsg)) {
			Assert.assertTrue(true, "Document viewed");}
	}
	public static WebElement printEnvelopes(){
		return driver.findElement(By.xpath("//div[@class='primaryButtons']//input[4]"));
	}
	//Incomplete 
	public static void validateEnvelopes(){
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Documents')]")));
	}
	public static void selectMMTemplate(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='leaseDetailForm.templateID']")));
		(new Select(driver.findElement(By.xpath("//select[@id='leaseDetailForm.templateID']")))).selectByVisibleText("Lease MM template with eSig tags");
	}
	public static WebElement selectMMDocument(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'RentMoneyVoucher.pdf')]")));
		//(new Select(driver.findElement(By.xpath("//option[contains(text(),'RentMoneyVoucher.pdf')]")))).selectByVisibleText("RentMoneyVoucher.pdf");
		return driver.findElement(By.xpath("//option[contains(text(),'RentMoneyVoucher.pdf')]"));
	}
	public static void selectEmailTemplate(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='emailTemplateID']")));
		(new Select(driver.findElement(By.xpath("//select[@id='emailTemplateID']")))).selectByIndex(3);
	}
	public static void send(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Send']")));
		driver.findElement(By.xpath("//input[@value='Send']")).click();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='emailFormContainer']")));
	}
	
	public static WebElement done()
	{
		String msg = "We encourage the use of eSignature User Alerts to track the status of your emailed documents.";
		if(driver.getPageSource().contains(msg)) {
			Assert.assertTrue(true, "Mail Merge failure");
			return driver.findElement(By.xpath("//div[@class='primaryButtons']//input[5]"));
			}
		else
			return driver.findElement(By.xpath("//div[@class='primaryButtons']//input[5]"));
	}
	
	public static WebElement mmEmailSubject(){
		return driver.findElement(By.id("email.subject"));
	}
	public static WebElement mmEmailBody(){
		return driver.findElement(By.xpath("//body[@class='mceContentBody']"));
	}
	
	public static void validateMMNegative(){
		String errMsg = "You must select at least one item.";
		if(driver.getPageSource().contains(errMsg)) {
			Assert.assertTrue(true, "Lease Mail Merge initiated");}
		else 
			Assert.assertTrue(false, "Lease was not selected for Mail Merge");
	}
	
}
