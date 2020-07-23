package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.DeleteLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.RentBump;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class MailMergeTest extends TestBase {
	
	@Test
	public void mailMerge() throws IOException, InterruptedException{
	test=extent.createTest("mailMerge");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	DeleteLease.firstLeaseCheckbox().click();
	
	
	}
}
