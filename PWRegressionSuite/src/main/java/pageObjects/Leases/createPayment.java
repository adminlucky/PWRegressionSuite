package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.TestBase;

public class createPayment extends TestBase {
	
	public static WebElement ledger(){
		return driver.findElement(By.xpath("//li[@id='tab2']"));
	}
	public static WebElement newPayment(){
		return driver.findElement(By.xpath("//*[@value='New Payment']"));
	}
	public static WebElement ref(){
		return driver.findElement(By.id("payment.refNo"));
	}
	public static WebElement comment(){
		return driver.findElement(By.name("payment.comments"));
	}
	public static WebElement prepayAmount(){
		return driver.findElement(By.xpath("//input[@id='payment.amountAsString']"));
	}
	public static WebElement selectUnpaidCharge(){
		return driver.findElement(By.xpath("//table[2]/tbody[1]/tr[2]/td[7]/input[1]"));
	}
	public static WebElement savePayment(){
		return driver.findElement(By.id("saveBtn"));
	}
}
