package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import dataReader.Excel_Reader;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import testBase.TestBase;
import utilities.UtilityMethods;


public class CreateNewLeaseTest extends TestBase {
	
	Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createLease() throws IOException, InterruptedException{
		test=extent.createTest("createLease");
		Login.refreshPage();
		String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		NewLease.newLeaseLink().click();
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
		AddAutoCharge.newAutoCharge().click();
		AddAutoCharge.startDate();
		AddAutoCharge.amount().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		AddAutoCharge.amount().sendKeys("$700");
		AddAutoCharge.desc().sendKeys("Rent auto charge");
		AddAutoCharge.saveAutoCharge();
		UtilityMethods.scrollDown(driver);
		NewLease.unScheduleInspection();
		NewLease.saveLease();
		NewLease.cancel();
		NewLeaseFromLeasePage.leaseSummaryLink();
		
	}

}
