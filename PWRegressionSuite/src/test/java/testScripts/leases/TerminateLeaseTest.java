package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.EditLease;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class TerminateLeaseTest extends TestBase {
	
	@Test
	public void terminateLease() throws IOException{
	test=extent.createTest("terminateLease");
	initialization();
	newLease.leases().click();
	newLease.activeLeases().click();
	MoveoutAndTerminateLease.firstActiveLease().click();
	EditLease.edit().click();
	EditLease.activeToTerminate();
	EditLease.publicAssistance();
	EditLease.description().sendKeys(Keys.END, " - Lease status changed from Active to Terminated");
	EditLease.vacatedDate();
	EditLease.save().click();
	EditLease.confirmTerminate();
	}
}
