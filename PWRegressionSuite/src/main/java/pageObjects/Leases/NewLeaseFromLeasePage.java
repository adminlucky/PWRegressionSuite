package pageObjects.Leases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class NewLeaseFromLeasePage extends TestBase {
	
	public static void leaseSummaryLink(){
		//return driver.findElement(By.xpath("//li[@id='tabDetail']"));
		driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]")).click();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='primaryButtons']//input[2]")));
	}
	public static WebElement newLeaseButton(){
		return driver.findElement(By.xpath("(//div[@class='primaryButtons']/input[@type='button'])[1]"));
	}
	public static WebElement ledger(){
		//return driver.findElement(By.xpath("//li[@id='tab2']"));
		return driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[2]"));
	}
	public static WebElement newLeaseLink(){
		return driver.findElement(By.xpath("//a[contains(text(),'New Lease')]"));
	}
	
	
}
