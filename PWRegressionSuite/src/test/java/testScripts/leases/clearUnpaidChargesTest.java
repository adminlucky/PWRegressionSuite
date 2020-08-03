package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.adjustments;
import pageObjects.Leases.clearUnpaidCharges;
import pageObjects.Leases.newLease;
import testBase.TestBase;

public class ClearUnpaidChargesTest extends TestBase {
	@Test
	public void clearUnpaidCharges() throws IOException, InterruptedException{
		test=extent.createTest("clearUnpaidCharges");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		newLease.leases().click();
		newLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		adjustments.clickLedger().click();
		clearUnpaidCharges.clearUnpaid().click();
		clearUnpaidCharges.ok();
	}
}
