package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class DraftToActiveTest extends TestBase {
	
	@Test
	public void draftToActive() throws IOException, InterruptedException{
	test=extent.createTest("draftToActive");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.draftLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	EditLease.edit();
	EditLease.removeLocation().click();
	newLease.location().click();
	newLease.selectLocation().click();
	newLease.done();
	EditLease.draftToActive();
	EditLease.publicAssistance();
	EditLease.description().sendKeys(Keys.END, " - Draft lease converted to active lease");
	EditLease.scheduleInspection().click();
	EditLease.inspectionStartDate();	//Need to improve
	EditLease.costEstimate().sendKeys(Keys.chord(Keys.CONTROL, "a"));
	EditLease.costEstimate().sendKeys("$40");
	EditLease.inspectionDesc().sendKeys("Sample Inspection");
	EditLease.saveLease();
	newLease.cancel();
	
	}
}
