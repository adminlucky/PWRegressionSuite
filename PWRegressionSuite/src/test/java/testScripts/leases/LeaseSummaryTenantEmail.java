package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.EmailTenants;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveOut;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.createCharge;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class LeaseSummaryTenantEmail extends TestBase {
	
	@Test
	public void leaseSummaryTenantEmail() throws IOException, InterruptedException{
	test=extent.createTest("leaseSummaryTenantEmail");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	UtilityMethods.scrollDownHalf(driver);
	EmailTenants.tenantEmailLink().click();
	
	EmailTenants.emailTemplate();
	EmailTenants.subject();
	EmailTenants.emailBody();
	EmailTenants.send();
	
	}
}
