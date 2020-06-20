package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class createJE extends TestBase {
	
	public static WebElement newJE(){
		return driver.findElement(By.xpath("//div[@class='primaryButtons']//input[4]"));
	}
	public static WebElement ref(){
		return driver.findElement(By.xpath("//input[@id='je.refNo']"));
	}
	public static WebElement comments(){
		return driver.findElement(By.xpath("//textarea[@name='je.comments']"));
	}
	public static void debitAccount(){
		(new Select(driver.findElement(By.xpath("//select[@id='jeSplit(0).glAccountID']")))).selectByIndex(1);
	}
	public static void creditAccount(){
		(new Select(driver.findElement(By.xpath("//select[@id='jeSplit(1).glAccountID']")))).selectByIndex(2);
	}
	public static WebElement debitAmount(){
		return driver.findElement(By.xpath("//input[@id='jeSplit(0).drAsString']"));
	}
	public static WebElement creditAmount(){
		return driver.findElement(By.xpath("//input[@id='jeSplit(1).crAsString']"));
	}
	public static WebElement saveJE(){
		return driver.findElement(By.xpath("//input[@id='saveje']"));
	}
}
