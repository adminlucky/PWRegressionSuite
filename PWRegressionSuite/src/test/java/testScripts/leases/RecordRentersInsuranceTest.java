package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.RentersInsurance;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class RecordRentersInsuranceTest extends TestBase {
	
	@Test
	public void recordRentersInsurance() throws IOException, InterruptedException{
	test=extent.createTest("recordRentersInsurance");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink().click();
	RentersInsurance.rentersInsuranceTab().click();
	RentersInsurance.recordPolicy().click();
	RentersInsurance.policyNumber().sendKeys("2479341");
	RentersInsurance.policyProvider();
	RentersInsurance.effectiveDate();
	RentersInsurance.nextRenewalDate();
	RentersInsurance.comments().sendKeys("Renters insurance for lease");
	UtilityMethods.scrollDownHalf(driver);
	RentersInsurance.save();
	
	}
}
