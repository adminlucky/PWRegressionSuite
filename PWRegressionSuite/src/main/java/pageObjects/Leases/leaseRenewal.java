package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class leaseRenewal extends TestBase {
	
	public static WebElement firstTerminatedLease(){
		return driver.findElement(By.xpath("//td[@id='cell_0_0']//self::a"));
	}
	public static WebElement renewalLease(){
		return driver.findElement(By.xpath("//a[contains(text(),'Lease Renewal')]"));
	}
	public static void newStartDate(){
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		driver.findElement(By.xpath("//input[@id='renewalStartDate']")).sendKeys(date);
		//Need to optimize for date selection
	}
	public static void newEndDate(){
		(new Select(driver.findElement(By.xpath("//select[@id='endDateSelect']")))).selectByIndex(3);
	}
	public static void renewedDate(){
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		driver.findElement(By.xpath("//input[@id='renewalOnDate']")).sendKeys(date);
	}
	public static WebElement save(){
		return driver.findElement(By.xpath("//div[10]/div[3]/input[1]"));
	}
}
