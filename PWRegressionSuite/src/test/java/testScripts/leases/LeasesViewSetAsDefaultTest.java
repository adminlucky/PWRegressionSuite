package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.CreateNewView;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveOut;
import pageObjects.Leases.createCharge;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class LeasesViewSetAsDefaultTest extends TestBase {
	
		@Test
		public void leasesViewSetAsDefault() throws IOException, InterruptedException{
			test=extent.createTest("leasesViewSetAsDefault");
			Login.refreshPage();
			AddAutoCharge.waitForLeases();
			newLease.leases().click();
			CreateNewView.setAsDefaultView();
			
	
	}
}
