package testScripts.leases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import dataReader.Excel_Reader;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import pageObjects.Leases.newLeaseWithExistingContact;
import testBase.TestBase;
import utilities.UtilityMethods;


public class NewLeaseWithExistingContactTest extends TestBase {
	
	Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createLeaseWithExistingContact() throws IOException, InterruptedException{
		test=extent.createTest("createLeaseWithExistingContact");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		newLease.leases().click();
		newLease.newLeaseLink().click();
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
		newLease.unScheduleInspection();
		newLease.saveLease();
		newLease.cancel();
		NewLeaseFromLeasePage.leaseSummaryLink();
	}

}
