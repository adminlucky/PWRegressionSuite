package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.DeleteLease;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.EmailTenants;
import pageObjects.Leases.Login;
import pageObjects.Leases.MailMerge;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.RentBump;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class LeaseEmailNegativeTest extends TestBase {
	
	@Test
	public void leaseEmailNegativeTest() throws IOException, InterruptedException{
	test=extent.createTest("LeaseEmailNegativeTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	EmailTenants.emailButton().click();
	EmailTenants.validateEmailNegative();
	}
}
