package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.Pagination;
import testBase.TestBase;
import utilities.UtilityMethods;


public class LeasesSwitchPagesTest extends TestBase {
	
		@Test
		public void leasesSwitchPagesTest() throws IOException, InterruptedException{
			test=extent.createTest("leasesSwitchPagesTest");
			Login.refreshPage();
			AddAutoCharge.waitForLeases();
			NewLease.leases().click();
			UtilityMethods.scrollDown(driver);
			Pagination.nextPage().click();
			Pagination.previousPage().click();
	
	}
}
