package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.LeaseRenewal;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import testBase.TestBase;


public class LeaseRenewalTest extends TestBase {
	@Test
	public void leaseRenewal() throws IOException, InterruptedException{
		test=extent.createTest("leaseRenewal");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		LeaseRenewal.terminatedLeases().click();
		LeaseRenewal.firstTerminatedLease().click();
		NewLeaseFromLeasePage.leaseSummaryLink();
		LeaseRenewal.renewalLease().click();
		//test.createNode("Lease renewal link clicked","Dates popup window will be opened");
		LeaseRenewal.newStartDate();
		LeaseRenewal.renewedDate();
		LeaseRenewal.newEndDate();
		LeaseRenewal.save();
		/*boolean save = leaseRenewal.save().isDisplayed();
		Assert.assertTrue(save);
		test.createNode("Save button displayed");
		Assert.assertFalse(save);
		test.createNode("Save button not displayed");*/
	}
}
