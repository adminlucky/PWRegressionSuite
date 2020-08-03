package testScripts.leases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.LeaseLedger;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import testBase.TestBase;

public class LateFeePageTest extends TestBase {
	
	@Test
	public void lateFeeNavigation() throws IOException, InterruptedException{
	test=extent.createTest("lateFeeNavigation");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.ledger().click();
	LeaseLedger.lateFee().click();
	Assert.assertTrue(driver.getPageSource().contains("Late Fee Calculator"));
	LeaseLedger.backToTenantLedger().click();
	}
}
