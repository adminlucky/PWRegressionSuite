package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.UtilityMethods;


public class MiscObjects extends TestBase {
	
	public static void selectPortfolio(){
		(new Select(driver.findElement(By.id("showingView.gridPropertyFilterOn")))).selectByVisibleText("-- GSPLLC --");
		AddAutoCharge.waitForLeases();
	}
	
	
}
