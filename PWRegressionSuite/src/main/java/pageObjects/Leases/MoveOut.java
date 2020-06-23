package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class MoveOut extends TestBase {
	
	public static void vacatedDate(){
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		driver.findElement(By.id("entity.moveOutDateAsString")).sendKeys(date);
	}
	
	public static void reason(){
		(new Select(driver.findElement(By.name("entity.reasonForLeaving")))).selectByVisibleText("MOVE CITY");
	}
	
	public static WebElement save(){
		return driver.findElement(By.xpath("(//input[@value='Save'])[1]"));
	}
}
