package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import dataReader.Excel_Reader;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.NewLeaseWithExistingContact;
import testBase.TestBase;


public class NewLeaseWithExistingContactTest extends TestBase {
	
	Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createLeaseWithExistingContact() throws IOException, InterruptedException{
		test=extent.createTest("createLeaseWithExistingContact");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		NewLease.newLeaseLink().click();
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
		NewLease.unScheduleInspection();
		NewLease.saveLease();
		NewLease.cancel();
		NewLeaseFromLeasePage.leaseSummaryLink();
	}

}
