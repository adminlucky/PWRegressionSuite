package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.LeaseLedger;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveOut;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class MoveOutTest extends TestBase {
	
	@Test
	public void moveOutLease() throws IOException, InterruptedException{
	test=extent.createTest("moveOutLease");
	Login.refreshPage();
	Login.homePage().click();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.ledger().click();
	LeaseLedger.moveOut().click();
	MoveOut.vacatedDate();
	MoveOut.reason();
	MoveOut.save().click();
	
	}
	
}
