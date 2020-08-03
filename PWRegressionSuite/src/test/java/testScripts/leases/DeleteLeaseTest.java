package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.DeleteLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class DeleteLeaseTest extends TestBase {
	
	@Test
	public void deleteLease() throws IOException, InterruptedException{
	test=extent.createTest("deleteLease");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.draftLeases().click();
	DeleteLease.firstLeaseCheckbox().click();
	DeleteLease.delete().click();
	DeleteLease.confirmDelete();
	}
}
