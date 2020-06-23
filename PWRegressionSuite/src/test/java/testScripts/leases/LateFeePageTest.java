package testScripts.leases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Leases.EditLease;
import pageObjects.Leases.LeaseLedger;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import testBase.TestBase;

public class LateFeePageTest extends TestBase {
	
	@Test
	public void lateFeeNavigation() throws IOException{
	test=extent.createTest("lateFeeNavigation");
	initialization();
	newLease.leases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.ledger().click();
	LeaseLedger.lateFee().click();
	Assert.assertTrue(driver.getPageSource().contains("Late Fee Calculator"));
	}
}
