package testScripts.leases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import dataReader.Excel_Reader;
import pageObjects.Leases.newLease;
import pageObjects.Leases.newLeaseWithExistingContact;
import testBase.TestBase;
import utilities.UtilityMethods;


public class newLeaseWithExistingContactTest extends TestBase {
	
	Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createLeaseWithExistingContact() throws IOException, InterruptedException{
		test=extent.createTest("createLeaseWithExistingContact");
		//initialization();
		String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
		newLease.leases().click();
		newLease.newLeaseLink().click();
		newLease.location().click();
		newLease.selectLocation().click();
		newLease.done();
		//newLease.status(driver);
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		newLease.startCalendar();
		//newLease.startDate().click();
		newLease.endDate();
		newLease.publicAssistance();
		newLease.addContactButton();
		newLease.createNewContactButton().click();
		newLeaseWithExistingContact.searchText().sendKeys("*");
		newLeaseWithExistingContact.searchButton().click();
		newLeaseWithExistingContact.saveContact().click();
		UtilityMethods.waitForElementToLoad(driver, "//div[7]//input[1]");
		UtilityMethods.scrollDown(driver);		
		newLease.saveLease();
		newLease.cancel();
	}

}
