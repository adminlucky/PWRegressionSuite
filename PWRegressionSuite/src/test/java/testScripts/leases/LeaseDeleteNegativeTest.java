package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.DeleteLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class LeaseDeleteNegativeTest extends TestBase {
	
	@Test
	public void leaseDeleteNegativeTest() throws IOException, InterruptedException{
	test=extent.createTest("LeaseDeleteNegativeTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	DeleteLease.delete().click();
	DeleteLease.confirmDelete();
	DeleteLease.validateLeaseDeletion();
	}
}
