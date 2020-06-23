package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.EditLease;
import pageObjects.Leases.LeaseNewWorkorder;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class LeaseNewWorkorderTest extends TestBase {
	
	@Test
	public void newWorkorder() throws IOException{
	test=extent.createTest("newWorkorder");
	initialization();
	newLease.leases().click();
	EditLease.firstLease().click();
	UtilityMethods.scrollDownHalf(driver);
	LeaseNewWorkorder.newWorkorder().click();
	LeaseNewWorkorder.source();
	if(LeaseNewWorkorder.tenantPortal().isSelected())
		LeaseNewWorkorder.tenantPortal().click();
	if(LeaseNewWorkorder.ownerPortal().isSelected())
		LeaseNewWorkorder.ownerPortal().click();
	
	LeaseNewWorkorder.woType();
	LeaseNewWorkorder.woCategory();
	LeaseNewWorkorder.estimatedCost().sendKeys(Keys.chord(Keys.CONTROL, "a"), "$25");
	LeaseNewWorkorder.description().sendKeys("Work order created from lease");
	LeaseNewWorkorder.saveWO().click();
	
	}
}
