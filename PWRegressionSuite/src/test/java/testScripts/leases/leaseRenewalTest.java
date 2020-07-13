package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Leases.Login;
import pageObjects.Leases.leaseRenewal;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class leaseRenewalTest extends TestBase {
	@Test
	public void leaseRenewal() throws IOException, InterruptedException{
		test=extent.createTest("leaseRenewal");
		Login.refreshPage();
		Login.homePage().click();
		newLease.leases().click();
		leaseRenewal.terminatedLeases().click();
		leaseRenewal.firstTerminatedLease().click();
		leaseRenewal.renewalLease().click();
		//test.createNode("Lease renewal link clicked","Dates popup window will be opened");
		leaseRenewal.newStartDate();
		leaseRenewal.renewedDate();
		leaseRenewal.newEndDate();
		leaseRenewal.save();
		/*boolean save = leaseRenewal.save().isDisplayed();
		Assert.assertTrue(save);
		test.createNode("Save button displayed");
		Assert.assertFalse(save);
		test.createNode("Save button not displayed");*/
	}
}
