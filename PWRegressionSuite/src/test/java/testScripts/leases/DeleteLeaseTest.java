package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.DeleteLease;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class DeleteLeaseTest extends TestBase {
	
	@Test
	public void deleteLease() throws IOException{
	test=extent.createTest("deleteLease");
	initialization();
	newLease.leases().click();
	newLease.draftLeases().click();
	DeleteLease.firstLeaseCheckbox().click();
	DeleteLease.delete().click();
	DeleteLease.confirmDelete();
	}
}
