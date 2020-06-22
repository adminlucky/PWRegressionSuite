package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.DeleteLease;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.MoveoutAndTerminateLease;
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
