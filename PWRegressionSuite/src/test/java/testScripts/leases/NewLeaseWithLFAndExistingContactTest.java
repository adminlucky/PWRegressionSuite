package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import dataReader.Excel_Reader;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import pageObjects.Leases.newLeaseWithExistingContact;
import pageObjects.Leases.newLeaseWithLeaseForm;
import testBase.TestBase;
import utilities.UtilityMethods;

public class NewLeaseWithLFAndExistingContactTest extends TestBase {

Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createLeaseWithLFAndExistingContact() throws IOException, InterruptedException{
		test=extent.createTest("createLeaseWithLFAndExistingContact");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		newLease.leases().click();
		newLease.newLeaseLink().click();
		newLeaseWithLeaseForm.leaseForm();
		newLease.location().click();
		newLease.selectLocation().click();
		newLease.done();
		newLease.startCalendar();
		newLease.endDate();
		newLease.publicAssistance();
		newLease.addContactButton();
		newLeaseWithExistingContact.searchText().sendKeys("*");
		newLeaseWithExistingContact.searchButton().click();
		newLeaseWithExistingContact.selectContact().click();
		newLeaseWithExistingContact.saveContact();
		newLeaseWithLeaseForm.scheduleInspection();
		newLeaseWithLeaseForm.inspectionStartDate();
		newLeaseWithLeaseForm.managedBy();
		newLeaseWithLeaseForm.costEstimate().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		newLeaseWithLeaseForm.costEstimate().sendKeys("$75");
		newLease.saveLease();
		newLeaseWithLeaseForm.cancel();
		NewLeaseFromLeasePage.leaseSummaryLink();
	}
}
