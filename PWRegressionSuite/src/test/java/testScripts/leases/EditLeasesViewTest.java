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


public class EditLeasesViewTest extends TestBase {
	
		@Test
		public void editLeasesView() throws IOException, InterruptedException{
			test=extent.createTest("editLeasesView");
			Login.refreshPage();
			AddAutoCharge.waitForLeases();
			newLease.leases().click();
			CreateNewView.selectView();
			CreateNewView.editView().click();
			CreateNewView.viewName().sendKeys(" updated");
			CreateNewView.order();
			CreateNewView.saveView();
	}
}
