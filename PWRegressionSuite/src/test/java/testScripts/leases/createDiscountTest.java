package testScripts.leases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.adjustments;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;

public class createDiscountTest extends TestBase {
	
	@Test
	public void createDiscount() throws IOException, InterruptedException{
		test=extent.createTest("createDiscount");
		//initialization();
		Login.refreshPage();
		Login.homePage().click();
		newLease.leases().click();
		newLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		//NewLeaseFromLeasePage.leaseSummaryLink().click();
		adjustments.clickLedger().click();
		adjustments.adjustmentsButton().click();
		adjustments.discount().click();
		adjustments.account();
		adjustments.ref().sendKeys("3217");
		adjustments.amount().sendKeys(Keys.chord(Keys.CONTROL,"a"));
		adjustments.amount().sendKeys("-26");
		adjustments.comment().sendKeys("Discount for testing purpose");
		adjustments.save();
			
	}

}