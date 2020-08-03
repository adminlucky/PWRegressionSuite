package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class CreatePayment extends TestBase {
	
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
	public static void confirmPrepay(){
		driver.switchTo().alert().accept();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div[2]/ul[1]/li[5]/a[1]")));
	}
}
