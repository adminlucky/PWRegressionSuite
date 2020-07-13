package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.TestBase;
import utilities.UtilityMethods;


public class AddAutoCharge extends TestBase {
	
	public static WebElement newAutoCharge(){
		//return driver.findElement(By.xpath("//div[@class='pageSection']//div[3]//input[1]"));
		//return driver.findElement(By.xpath("//*[@id='leaseEditForm']/div[6]/div[3]/input"));
		return driver.findElement(By.xpath("//table[1]/tbody[1]/tr[1]/td[1]/div[1]/form[1]/div[6]/div[3]/input[1]"));
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
	public static void saveAutoCharge(){
		driver.findElement(By.xpath("//div[@id='editAutoChargeForm']//div[@class='primaryButtons']//input[1]")).click();
		UtilityMethods.waitForElementToBeInvisible(driver, "//div[@id='editAutoChargeForm']");
	}
	
	
}
