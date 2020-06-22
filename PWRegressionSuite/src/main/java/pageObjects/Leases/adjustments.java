package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testBase.TestBase;


public class adjustments extends TestBase {
	
	public static WebElement clickLedger(){
		return driver.findElement(By.xpath("//li[@id='tab2']"));
	}
	public static WebElement adjustmentsButton(){
		return driver.findElement(By.xpath("//div[@class='primaryButtons']//input[3]"));
	}
	//Adjustment related object locators
	public static WebElement adjustment(){
		return driver.findElement(By.xpath("(//input[@id='refundType'])[1]"));
	}
	public static WebElement ref(){
		return driver.findElement(By.xpath("//input[@id='refund.refNo']"));
	}
	
	public static WebElement amount(){
		return driver.findElement(By.xpath("//input[@id='refund.editAmountAsString']"));
	}
	public static WebElement comment(){
		return driver.findElement(By.xpath("//input[@name='refund.comments']"));
	}
	public static WebElement save(){
		return driver.findElement(By.xpath("//form[1]/div[10]/div[4]/input[1]"));
	}
	
	//Discount related object locators
	public static WebElement discount(){
		return driver.findElement(By.xpath("(//input[@id='refundType'])[2]"));
	}
	public static void account(){
		(new Select(driver.findElement(By.xpath("//select[@id='discountAccountID']")))).selectByIndex(1);
	}
	
	
	//Refund related object locators
	public static WebElement refund(){
		return driver.findElement(By.xpath("(//input[@id='refundType'])[3]"));
	}
	public static void payFrom(){
		(new Select(driver.findElement(By.xpath("//select[@id='payTenantFromAccountID']")))).selectByIndex(3);
	}
		
		
	
}
