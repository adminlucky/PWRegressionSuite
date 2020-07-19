package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
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
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	UtilityMethods.scrollDown(driver);
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
