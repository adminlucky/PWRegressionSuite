package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testBase.TestBase;

public class RentBump extends TestBase {

	public static WebElement rentBump(){
		return driver.findElement(By.xpath("//a[contains(text(),'Rent Bump')]"));
	}
	public static WebElement rentBumpType(){
		return driver.findElement(By.xpath("//input[@id='chargeAmount']"));
	}
	public static WebElement rentBumpAmount(){
		return driver.findElement(By.id("rentalBumpAmountAsString"));
	}
	public static WebElement save(){
		return driver.findElement(By.id("sendButton"));
	}
	public static WebElement done(){
		return driver.findElement(By.xpath("//input[@value='Done']"));
	}
	
}
