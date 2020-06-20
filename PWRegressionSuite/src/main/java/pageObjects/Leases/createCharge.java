package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class createCharge extends TestBase{
	public static WebElement element = null; 
	
	public static WebElement clickLedger(){
		return driver.findElement(By.xpath("//li[@id='tab2']"));
	}
	public static WebElement newCharge(){
		return driver.findElement(By.xpath("//div[@class='primaryButtons']//input[2]"));
	}
	public static void selectAccount(){
		(new Select(driver.findElement(By.xpath("//select[@id='oneTimeGLAccountID']")))).selectByIndex(3);
	}
	public static WebElement chargeRef(){
		return driver.findElement(By.xpath("//input[@id='charge.refNo']"));
	}
	public static WebElement amount(){
		return driver.findElement(By.xpath("//input[@id='charge.editAmountAsString']"));
	}
	public static void chargeDate(){
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		driver.findElement(By.xpath("//input[@id='charge.dateAsString']")).sendKeys(date);
	}
	public static WebElement chargeComment(){
		return driver.findElement(By.xpath("//input[@name='charge.comments']"));
	}
	public static WebElement saveCharge(){
		return driver.findElement(By.xpath("//input[@value='Save']"));
	}
}
