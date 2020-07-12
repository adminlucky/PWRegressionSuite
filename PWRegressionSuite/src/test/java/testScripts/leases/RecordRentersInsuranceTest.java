package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.RentersInsurance;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class RecordRentersInsuranceTest extends TestBase {
	
	@Test
	public void recordRentersInsurance() throws IOException{
	test=extent.createTest("recordRentersInsurance");
	initialization();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink().click();
	RentersInsurance.rentersInsuranceTab().click();
	RentersInsurance.recordPolicy().click();
	RentersInsurance.policyNumber().sendKeys("2479341");
	RentersInsurance.policyProvider();
	
	}
}
