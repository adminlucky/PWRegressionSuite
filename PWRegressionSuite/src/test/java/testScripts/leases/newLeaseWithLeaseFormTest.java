package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import dataReader.Excel_Reader;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.NewLeaseWithLeaseForm;
import testBase.TestBase;

public class NewLeaseWithLeaseFormTest extends TestBase {

Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createLeaseWithLeaseForm() throws IOException, InterruptedException{
		test=extent.createTest("createLeaseWithLeaseForm");
		Login.refreshPage();
		String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
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
		NewLeaseWithLeaseForm.createNewContactButton().click();
		String fname=xlReader.readExcel(driver,filepath,"Leases",1,0);
		NewLease.firstname().sendKeys(fname);
		String lname=xlReader.readExcel(driver,filepath,"Leases",1,1);
		NewLease.lastname().sendKeys(lname);
		String email=xlReader.readExcel(driver,filepath,"Leases",1,2);
		NewLease.email().sendKeys(email);
		NewLease.saveNewContact();
		NewLeaseWithLeaseForm.scheduleInspection();
		NewLeaseWithLeaseForm.inspectionStartDate();
		NewLeaseWithLeaseForm.managedBy();
		NewLeaseWithLeaseForm.costEstimate().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		NewLeaseWithLeaseForm.costEstimate().sendKeys("$50");
		NewLease.saveLease();
		NewLease.cancel();
		NewLeaseFromLeasePage.leaseSummaryLink();
	}
}
