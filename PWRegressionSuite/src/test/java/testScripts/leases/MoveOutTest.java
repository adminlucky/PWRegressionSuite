package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Adjustments;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.LeaseLedger;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveOut;
import pageObjects.Leases.NewLease;
import testBase.TestBase;

public class MoveOutTest extends TestBase {
	
	@Test
	public void moveOutLease() throws IOException, InterruptedException{
	test=extent.createTest("moveOutLease");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	EditLease.firstLease().click();
	Adjustments.clickLedger().click();
	LeaseLedger.moveOut().click();
	MoveOut.vacatedDate();
	MoveOut.reason();
	MoveOut.save().click();
	
	}
	
}
