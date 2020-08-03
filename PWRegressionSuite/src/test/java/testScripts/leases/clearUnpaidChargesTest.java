package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Adjustments;
import pageObjects.Leases.ClearUnpaidCharges;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.NewLease;
import testBase.TestBase;

public class ClearUnpaidChargesTest extends TestBase {
	@Test
	public void clearUnpaidCharges() throws IOException, InterruptedException{
		test=extent.createTest("clearUnpaidCharges");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		NewLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		Adjustments.clickLedger().click();
		ClearUnpaidCharges.clearUnpaid().click();
		ClearUnpaidCharges.ok();
	}
}
