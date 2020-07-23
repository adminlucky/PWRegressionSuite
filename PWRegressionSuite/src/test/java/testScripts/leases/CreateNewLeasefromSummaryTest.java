package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;

import dataReader.Excel_Reader;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class CreateNewLeasefromSummaryTest extends TestBase {
	
	Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createNewLeasefromSummaryPage() throws IOException, InterruptedException{
		test=extent.createTest("createNewLeasefromSummaryPage");
		Login.refreshPage();
		String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
		AddAutoCharge.waitForLeases();
		newLease.leases().click();
		EditLease.firstLease().click();
		NewLeaseFromLeasePage.leaseSummaryLink();
		NewLeaseFromLeasePage.newLeaseButton().click(); 
		newLease.location().click();
		newLease.selectLocation().click();
		newLease.done();
		//newLease.status();
		newLease.startCalendar();
		newLease.endDate();
		newLease.publicAssistance();
		newLease.addContactButton();
		newLease.createNewContactButton().click();
		String fname=xlReader.readExcel(driver,filepath,"Leases",1,0);
		newLease.firstname().sendKeys(fname);
		String lname=xlReader.readExcel(driver,filepath,"Leases",1,1);
		newLease.lastname().sendKeys(lname);
		String email=xlReader.readExcel(driver,filepath,"Leases",1,2);
		newLease.email().sendKeys(email);
		newLease.saveNewContact();
		//UtilityMethods.scrollDown(driver);
		newLease.unScheduleInspection();
		newLease.saveLease();
		newLease.cancel();
		NewLeaseFromLeasePage.leaseSummaryLink();
	}

}
