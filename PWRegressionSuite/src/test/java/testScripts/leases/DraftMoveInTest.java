package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.CreateCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveOut;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class DraftMoveInTest extends TestBase {
	
	@Test
	public void draftMoveIn() throws IOException, InterruptedException{
	test=extent.createTest("draftMoveIn");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.draftLeases().click();
	EditLease.firstLease().click();
	CreateCharge.clickLedger().click();
	MoveOut.moveIn().click();
	MoveOut.leaseFeeRefNo().sendKeys("43276");
	MoveOut.paidCheckbox().click();
	MoveOut.toBePrinted().click();
	MoveOut.save().click();
	
	}
}
