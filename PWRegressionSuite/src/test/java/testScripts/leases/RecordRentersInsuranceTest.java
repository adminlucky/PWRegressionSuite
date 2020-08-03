package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.RentersInsurance;
import testBase.TestBase;
import utilities.UtilityMethods;


public class RecordRentersInsuranceTest extends TestBase {
	
	@Test
	public void recordRentersInsurance() throws IOException, InterruptedException{
	test=extent.createTest("recordRentersInsurance");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	RentersInsurance.rentersInsuranceTab().click();
	RentersInsurance.recordPolicy().click();
	RentersInsurance.policyNumber().sendKeys("2479341");
	RentersInsurance.policyProvider();
	RentersInsurance.effectiveDate();
	RentersInsurance.nextRenewalDate();
	RentersInsurance.comments().sendKeys("Renters insurance for lease");
	UtilityMethods.scrollDownHalf(driver);
	RentersInsurance.upload().sendKeys("C:\\RAMAKRISHNA\\Propertyware\\Propertyware Documents\\Sample files\\RentMoneyVoucher.pdf");
	RentersInsurance.save();
	
	}
}
