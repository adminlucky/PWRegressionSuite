package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.CreateNewView;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class LeasesViewSetAsDefaultTest extends TestBase {
	
		@Test
		public void leasesViewSetAsDefault() throws IOException, InterruptedException{
			test=extent.createTest("leasesViewSetAsDefault");
			Login.refreshPage();
			AddAutoCharge.waitForLeases();
			NewLease.leases().click();
			CreateNewView.setAsDefaultView();
			
	
	}
}
