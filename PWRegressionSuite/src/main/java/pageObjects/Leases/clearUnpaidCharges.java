package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.TestBase;
import utilities.UtilityMethods;

public class clearUnpaidCharges extends TestBase {
	
	public static WebElement clearUnpaid(){
		UtilityMethods.scrollDownHalf(driver);
		return driver.findElement(By.linkText("Clear Unpaid"));
	}
	public static void ok(){
		driver.switchTo().alert().accept();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div[2]/ul[1]/li[5]/a[1]")));
	}
}
