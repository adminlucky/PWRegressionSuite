package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.CreateNewView;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class EditLeasesViewTest extends TestBase {
	
		@Test
		public void editLeasesView() throws IOException, InterruptedException{
			test=extent.createTest("editLeasesView");
			Login.refreshPage();
			AddAutoCharge.waitForLeases();
			NewLease.leases().click();
			CreateNewView.selectView();
			CreateNewView.editView().click();
			CreateNewView.viewName().sendKeys(" updated");
			CreateNewView.order();
			CreateNewView.saveView();
	}
}
