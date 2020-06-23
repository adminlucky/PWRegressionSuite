package pageObjects.Leases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testBase.TestBase;

public class NewLeaseFromLeasePage extends TestBase {
	
	public static WebElement leaseSummaryLink(){
		return driver.findElement(By.xpath("//li[@id='tabDetail']"));
	}
	public static WebElement newLeaseButton(){
		return driver.findElement(By.xpath("(//div[@class='primaryButtons']/input[@type='button'])[1]"));
	}
	public static WebElement ledger(){
		return driver.findElement(By.xpath("//li[@id='tab2']"));
	}
	public static WebElement newLeaseLink(){
		return driver.findElement(By.xpath("//a[contains(text(),'New Lease')]"));
	}
	
	
}
