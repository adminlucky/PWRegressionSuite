package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.CreateNewView;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class CreateLeasesNewViewTest extends TestBase {
	
		@Test
		public void createLeasesNewView() throws IOException, InterruptedException{
			test=extent.createTest("createLeasesNewView");
			Login.refreshPage();
			AddAutoCharge.waitForLeases();
			NewLease.leases().click();
			CreateNewView.newView().click();
			CreateNewView.viewName().sendKeys("Draft Leases");
			CreateNewView.unSelectedColumn();
			CreateNewView.addColumnToView().click();
			UtilityMethods.scrollDownHalf(driver);
			CreateNewView.selectFilterColumn();
			CreateNewView.selectCondition();
			CreateNewView.value();
			CreateNewView.addFilter().click();
			CreateNewView.saveView();
		
		}
}
