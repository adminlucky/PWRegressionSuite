package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EmailTenants;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class LeaseEmailNegativeTest extends TestBase {
	
	@Test
	public void leaseEmailNegativeTest() throws IOException, InterruptedException{
	test=extent.createTest("LeaseEmailNegativeTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	EmailTenants.emailButton().click();
	EmailTenants.validateEmailNegative();
	}
}
