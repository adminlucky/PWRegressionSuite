package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class LeaseNewWorkorder extends TestBase {
	
	public static WebElement newWorkorder(){
		return driver.findElement(By.xpath("//a[contains(text(),'New Work Order')]"));
	}
	public static void source(){
		(new Select(driver.findElement(By.xpath("//select[@name='entity.source']")))).selectByVisibleText("Email");
	}
	public static WebElement tenantPortal(){
		return driver.findElement(By.name("entity.publishToTenantPortal"));
	}
	public static WebElement ownerPortal(){
		return driver.findElement(By.name("entity.publishToOwnerPortal"));
	}
	public static void woType(){
		(new Select(driver.findElement(By.xpath("//select[@name='entity.type']")))).selectByVisibleText("Inspection");
	}
	public static void woCategory(){
		(new Select(driver.findElement(By.xpath("//select[@name='entity.category']")))).selectByVisibleText("Move In Maintenance");
	}
	public static WebElement estimatedCost(){
		return driver.findElement(By.xpath("//input[@name='entity.costEstimateAsString']"));
	}
	public static WebElement description(){
		return driver.findElement(By.name("entity.description"));
	}
	public static WebElement saveWO(){
		return driver.findElement(By.xpath("//div[9]//input[1]"));
	}
	
}
