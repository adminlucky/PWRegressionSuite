package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testBase.TestBase;

public class DeleteLease extends TestBase {
	
	public static WebElement firstLeaseCheckbox(){
		return driver.findElement(By.xpath("(//input[starts-with(@id,'lease_')])[1]"));
	}
	public static WebElement delete(){
		return driver.findElement(By.xpath("//input[@value='Delete']"));
	}
	public static void confirmDelete(){
		driver.switchTo().alert().accept();
	}
}
