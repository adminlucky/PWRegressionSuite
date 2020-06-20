package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.createPayment;
import testBase.TestBase;

public class createPaymentTest extends TestBase {

	@Test
	public void createPayment() throws IOException{
		//test=extent.createTest("createPayment");
		initialization();
		//UtilityMethods.waitForElementToLoad(driver, "//a[contains(text(),'Leases')]");
		driver.findElement(By.xpath("//a[contains(text(),'Leases')]")).click();
		driver.findElement(By.xpath("//a[@href=\"javascript:showActive('Active');\"]")).click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		createPayment.ledger().click();
		createPayment.newPayment().click();
		createPayment.ref().sendKeys("3214");
		createPayment.comment().sendKeys("Test for payment creation");
		//Selecting unpaid charge or making prepayment
		if(driver.getPageSource().contains("No Outstanding Charges"))
		{
			createPayment.prepayAmount().sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			createPayment.prepayAmount().sendKeys("$150");
			createPayment.savePayment().click();
			driver.switchTo().alert().accept();
		}
		else{
			createPayment.selectUnpaidCharge().click();
			createPayment.savePayment().click();
		}
		
		
	}
}
