package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div[2]/ul[1]/li[5]/a[1]")));
	}
	
}
