package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.TestBase;
import utilities.UtilityMethods;

public class ClearUnpaidCharges extends TestBase {
	
	public static WebElement clearUnpaid(){
		UtilityMethods.scrollDownHalf(driver);
		return driver.findElement(By.linkText("Clear Unpaid"));
	}
	public static void ok(){
		driver.switchTo().alert().accept();
		AddAutoCharge.waitForLeases();
	}
}
