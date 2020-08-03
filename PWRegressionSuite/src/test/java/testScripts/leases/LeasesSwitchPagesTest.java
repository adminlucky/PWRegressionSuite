package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.CreateNewView;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveOut;
import pageObjects.Leases.Pagination;
import pageObjects.Leases.createCharge;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class LeasesSwitchPagesTest extends TestBase {
	
		@Test
		public void leasesSwitchPagesTest() throws IOException, InterruptedException{
			test=extent.createTest("leasesSwitchPagesTest");
			Login.refreshPage();
			AddAutoCharge.waitForLeases();
			newLease.leases().click();
			UtilityMethods.scrollDown(driver);
			Pagination.nextPage().click();
			Thread.sleep(5000);
			Pagination.previousPage().click();
	
	}
}
