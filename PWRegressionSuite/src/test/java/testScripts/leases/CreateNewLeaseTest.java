package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import dataReader.Excel_Reader;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class CreateNewLeaseTest extends TestBase {
	
	Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createLease() throws IOException, InterruptedException{
		test=extent.createTest("createLease");
		Login.refreshPage();
		Login.homePage().click();
		String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
		newLease.leases().click();
		newLease.newLeaseLink().click();
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
		AddAutoCharge.newAutoCharge().click();
		AddAutoCharge.startDate();
		AddAutoCharge.amount().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		AddAutoCharge.amount().sendKeys("$700");
		AddAutoCharge.desc().sendKeys("Rent auto charge");
		AddAutoCharge.saveAutoCharge();
		UtilityMethods.scrollDown(driver);
		newLease.unScheduleInspection();
		newLease.saveLease();
		newLease.cancel();
		NewLeaseFromLeasePage.leaseSummaryLink().click();
		
	}

}
