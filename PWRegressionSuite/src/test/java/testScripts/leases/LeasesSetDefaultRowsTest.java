package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.Pagination;
import testBase.TestBase;
import utilities.UtilityMethods;


public class LeasesSetDefaultRowsTest extends TestBase {
	
		@Test
		public void leasesSetDefaultRowsTest() throws IOException, InterruptedException{
			test=extent.createTest("leasesSetDefaultRowsTest");
			Login.refreshPage();
			AddAutoCharge.waitForLeases();
			NewLease.leases().click();
			UtilityMethods.scrollDown(driver);
			Pagination.rowsSetAsDefault();
	
	}
}
