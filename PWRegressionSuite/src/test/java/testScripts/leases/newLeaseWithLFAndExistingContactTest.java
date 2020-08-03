package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import dataReader.Excel_Reader;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.NewLeaseWithExistingContact;
import pageObjects.Leases.NewLeaseWithLeaseForm;
import testBase.TestBase;


public class NewLeaseWithLFAndExistingContactTest extends TestBase {

Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createLeaseWithLFAndExistingContact() throws IOException, InterruptedException{
		test=extent.createTest("createLeaseWithLFAndExistingContact");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		NewLease.newLeaseLink().click();
		NewLeaseWithLeaseForm.leaseForm();
		NewLease.location().click();
		NewLease.selectLocation().click();
		NewLease.done();
		NewLease.startCalendar();
		NewLease.endDate();
		NewLease.publicAssistance();
		NewLease.addContactButton();
		NewLeaseWithExistingContact.searchText().sendKeys("*");
		NewLeaseWithExistingContact.searchButton().click();
		NewLeaseWithExistingContact.selectContact().click();
		NewLeaseWithExistingContact.saveContact();
		NewLeaseWithLeaseForm.scheduleInspection();
		NewLeaseWithLeaseForm.inspectionStartDate();
		NewLeaseWithLeaseForm.managedBy();
		NewLeaseWithLeaseForm.costEstimate().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		NewLeaseWithLeaseForm.costEstimate().sendKeys("$75");
		NewLease.saveLease();
		NewLeaseWithLeaseForm.cancel();
		NewLeaseFromLeasePage.leaseSummaryLink();
	}
}
