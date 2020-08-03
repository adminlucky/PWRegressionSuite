package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testBase.TestBase;
import utilities.UtilityMethods;


public class LeaseConversations extends TestBase {
	
	public static WebElement conversationsTab(){
		return driver.findElement(By.id("cHeader"));
	}
	//Tenant conversation related elements
	public static void tenantConversation(){
		(new Select(driver.findElement(By.name("conversationType")))).selectByIndex(1);
	}
	
	public static WebElement comments(){
		return driver.findElement(By.id("conversationComment"));
	}
	public static WebElement share(){
		return driver.findElement(By.xpath("//input[@value='Share']"));
	}
	public static WebElement clickTenant(){
		return driver.findElement(By.xpath("//form[1]/div[7]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
	}
	
	public static WebElement portalTab(){
		return driver.findElement(By.xpath("//a[@href='#subtab6']"));
	}
	public static WebElement tenantLoginAs(){
		return driver.findElement(By.xpath("//div[@id='contactPageSection']//input[4]"));
	}
	
	public static void verifyTenantConversation(String comment){
		String tenantComment = comment;
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Documents')]")));
		if(driver.getPageSource().contains(tenantComment)) {
			Assert.assertTrue(true, "Tenant Conversation posted successfully");
			driver.close();
			}
		else {
			driver.close();
			Assert.assertTrue(false, "Tenant Conversation not posted");
			
		}
	}
	//Owner conversation related elements
	public static void ownerConversation(){
		(new Select(driver.findElement(By.name("conversationType")))).selectByIndex(2);
	}
	public static WebElement clickBuilding(){
		return driver.findElement(By.xpath("//div[@class='pageSection']//a[2]"));
	}
	public static WebElement clickOwner(){
		return driver.findElement(By.xpath("//table[3]/tbody[1]/tr[1]/td[1]/a[1]"));
	}
	public static WebElement ownerLoginAs(){
		return driver.findElement(By.xpath("//div[@id='contactPageSection']//input[4]"));
	}
	public static void verifyOwnerConversation(String comment){
		String ownerComment = comment;
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Maintenance')]")));
		if(driver.getPageSource().contains(ownerComment)) {
			Assert.assertTrue(true, "Owner Conversation posted successfully");
			driver.close();
			}
		else {
			driver.close();
			Assert.assertTrue(false, "Owner Conversation not posted");
			
		}
	}
	//Management conversation related elements
	public static void mgmtConversation(){
		(new Select(driver.findElement(By.name("conversationType")))).selectByIndex(0);
	}
	public static WebElement switchToDesktop(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div[2]/ul[1]/li[1]/a[1]")));
		return driver.findElement(By.xpath("//div[3]/div[2]/div[2]/ul[1]/li[1]/a[1]"));
	}
	public static void filterMgmtConversations(){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("conversationFilterMode")));
		(new Select(driver.findElement(By.id("conversationFilterMode")))).selectByIndex(0);
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Share']")));
	}
	public static void verifyMgmtConversation(String comment){
		String mgmtComment = comment;
		if(driver.getPageSource().contains(mgmtComment)) {
			Assert.assertTrue(true, "Management Conversation posted successfully");
			driver.close();
			}
		else {
			driver.close();
			Assert.assertTrue(false, "Management Conversation not posted");
			
		}
	}
	
}
