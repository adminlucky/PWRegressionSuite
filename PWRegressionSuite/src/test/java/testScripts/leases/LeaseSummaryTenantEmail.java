package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.EmailTenants;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import testBase.TestBase;
import utilities.UtilityMethods;


public class LeaseSummaryTenantEmail extends TestBase {
	
	@Test
	public void leaseSummaryTenantEmail() throws IOException, InterruptedException{
	test=extent.createTest("leaseSummaryTenantEmail");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
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
