package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testBase.TestBase;

public class LeaseLedger extends TestBase {
		
	public static WebElement applySecDepToCharges(){
		return driver.findElement(By.xpath("//a[contains(text(),'Apply SECDEP to Charges')]"));
	}
	public static WebElement printLedger(){
		return driver.findElement(By.xpath("//div[@class='primaryButtons']//input[7]"));
	}
	public static WebElement closeWindow(){
		return driver.findElement(By.xpath("//a[contains(text(),'Close Window')]"));
	}
	public static WebElement moveOut(){
		return driver.findElement(By.xpath("//input[@class='button redBack']"));
	}
	public static WebElement lateFee(){
		return driver.findElement(By.xpath("//input[@value='Late Fee']"));
	}
}
