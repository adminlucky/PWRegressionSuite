package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import dataReader.Excel_Reader;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import testBase.TestBase;


public class CreateNewLeasefromSummaryTest extends TestBase {
	
	Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createNewLeasefromSummaryPage() throws IOException, InterruptedException{
		test=extent.createTest("createNewLeasefromSummaryPage");
		Login.refreshPage();
		String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		EditLease.firstLease().click();
		NewLeaseFromLeasePage.leaseSummaryLink();
		NewLeaseFromLeasePage.newLeaseButton().click(); 
		NewLease.location().click();
		NewLease.selectLocation().click();
		NewLease.done();
		//newLease.status();
		NewLease.startCalendar();
		NewLease.endDate();
		NewLease.publicAssistance();
		NewLease.addContactButton();
		NewLease.createNewContactButton().click();
		String fname=xlReader.readExcel(driver,filepath,"Leases",1,0);
		NewLease.firstname().sendKeys(fname);
		String lname=xlReader.readExcel(driver,filepath,"Leases",1,1);
		NewLease.lastname().sendKeys(lname);
		String email=xlReader.readExcel(driver,filepath,"Leases",1,2);
		NewLease.email().sendKeys(email);
		NewLease.saveNewContact();
		//UtilityMethods.scrollDown(driver);
		NewLease.unScheduleInspection();
		NewLease.saveLease();
		NewLease.cancel();
		NewLeaseFromLeasePage.leaseSummaryLink();
	}

}
