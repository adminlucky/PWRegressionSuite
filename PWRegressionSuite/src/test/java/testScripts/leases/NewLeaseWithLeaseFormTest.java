package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import dataReader.Excel_Reader;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import pageObjects.Leases.newLeaseWithLeaseForm;
import testBase.TestBase;
import utilities.UtilityMethods;

public class NewLeaseWithLeaseFormTest extends TestBase {

Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createLeaseWithLeaseForm() throws IOException, InterruptedException{
		test=extent.createTest("createLeaseWithLeaseForm");
		Login.refreshPage();
		Login.homePage().click();
		String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
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
		newLeaseWithLeaseForm.createNewContactButton().click();
		String fname=xlReader.readExcel(driver,filepath,"Leases",1,0);
		newLease.firstname().sendKeys(fname);
		String lname=xlReader.readExcel(driver,filepath,"Leases",1,1);
		newLease.lastname().sendKeys(lname);
		String email=xlReader.readExcel(driver,filepath,"Leases",1,2);
		newLease.email().sendKeys(email);
		newLease.saveNewContact();
		newLeaseWithLeaseForm.scheduleInspection();
		newLeaseWithLeaseForm.inspectionStartDate();
		newLeaseWithLeaseForm.managedBy();
		newLeaseWithLeaseForm.costEstimate().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		newLeaseWithLeaseForm.costEstimate().sendKeys("$50");
		newLease.saveLease();
		newLeaseWithLeaseForm.cancel();
		NewLeaseFromLeasePage.leaseSummaryLink().click();
	}
}
