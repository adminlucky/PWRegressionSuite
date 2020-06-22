package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testBase.TestBase;
import utilities.UtilityMethods;

public class clearUnpaidCharges extends TestBase {
	
	public static WebElement clearUnpaid(){
		UtilityMethods.scrollDownHalf(driver);
		return driver.findElement(By.linkText("Clear Unpaid"));
	}
	public static void ok(){
		driver.switchTo().alert().accept();
	}
}
