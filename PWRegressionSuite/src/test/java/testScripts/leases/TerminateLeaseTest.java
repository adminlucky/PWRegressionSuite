package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import testBase.TestBase;

public class TerminateLeaseTest extends TestBase {
	
	@Test
	public void terminateLease() throws IOException, InterruptedException{
	test=extent.createTest("terminateLease");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	MoveoutAndTerminateLease.firstActiveLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	EditLease.edit();
	EditLease.activeToTerminate();
	EditLease.publicAssistance();
	EditLease.description().sendKeys(Keys.END, " - Lease status changed from Active to Terminated");
	EditLease.vacatedDate();
	EditLease.saveTerminate();
	
	}
}
