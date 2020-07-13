package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.EditLease;
import pageObjects.Leases.LeaseMaintTab;
import pageObjects.Leases.LeaseNewWorkorder;
import pageObjects.Leases.Login;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class CreateWOFromMaintTabTest extends TestBase {
	
	@Test
	public void newWorkorderFromMaintTab() throws IOException, InterruptedException{
	test=extent.createTest("newWorkorderFromMaintTab");
	Login.refreshPage();
	Login.homePage().click();
	newLease.leases().click();
	newLease.activeLeases().click();
	UtilityMethods.scrollDown(driver);
	//LeaseNewWorkorder.newWorkorder().click();
	LeaseMaintTab.maintTab().click();
	LeaseMaintTab.newWOButton().click();
	LeaseNewWorkorder.source();
	if(LeaseNewWorkorder.tenantPortal().isSelected())
		LeaseNewWorkorder.tenantPortal().click();
	if(LeaseNewWorkorder.ownerPortal().isSelected())
		LeaseNewWorkorder.ownerPortal().click();
	
	LeaseNewWorkorder.woType();
	LeaseNewWorkorder.woCategory();
	LeaseNewWorkorder.estimatedCost().sendKeys(Keys.chord(Keys.CONTROL, "a"), "$25");
	LeaseNewWorkorder.description().sendKeys("Work order created from lease Maintenance tab");
	LeaseNewWorkorder.saveWO().click();
	
	}
}
