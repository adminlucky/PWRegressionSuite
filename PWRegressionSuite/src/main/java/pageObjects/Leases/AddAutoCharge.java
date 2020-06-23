package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.TestBase;


public class AddAutoCharge extends TestBase {
	
	public static WebElement newAutoCharge(){
		return driver.findElement(By.xpath("//div[@class='pageSection']//div[3]//input[1]"));
	}
	public static void startDate(){
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		driver.findElement(By.xpath("//input[@id='charge.startDateAsString']")).sendKeys(date);
	}
	public static WebElement amount(){
		return driver.findElement(By.id("charge.amountAsString"));
	}
	public static WebElement desc(){
		return driver.findElement(By.id("charge.description"));
	}
	public static WebElement save(){
		return driver.findElement(By.xpath("//div[@id='editAutoChargeForm']//div[@class='primaryButtons']//input[1]"));
	}
	
	
}
