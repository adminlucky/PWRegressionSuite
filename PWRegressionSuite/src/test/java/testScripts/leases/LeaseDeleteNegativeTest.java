package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.DeleteLease;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.MailMerge;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.RentBump;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class LeaseDeleteNegativeTest extends TestBase {
	
	@Test
	public void leaseDeleteNegativeTest() throws IOException, InterruptedException{
	test=extent.createTest("LeaseDeleteNegativeTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	DeleteLease.delete().click();
	DeleteLease.confirmDelete();
	DeleteLease.validateLeaseDeletion();
	}
}
