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


public class LeasesSetDefaultRowsTest extends TestBase {
	
		@Test
		public void leasesSetDefaultRowsTest() throws IOException, InterruptedException{
			test=extent.createTest("leasesSetDefaultRowsTest");
			Login.refreshPage();
			AddAutoCharge.waitForLeases();
			newLease.leases().click();
			UtilityMethods.scrollDown(driver);
			Pagination.rowsSetAsDefault();
	
	}
}
