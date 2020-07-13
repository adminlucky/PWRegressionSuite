package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.createPayment;
import pageObjects.Leases.newLease;
import testBase.TestBase;

public class createPaymentTest extends TestBase {

	@Test
	public void createPayment() throws IOException, InterruptedException{
		test=extent.createTest("createPayment");
		Login.refreshPage();
		Login.homePage().click();
		newLease.leases().click();
		newLease.activeLeases().click();
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
