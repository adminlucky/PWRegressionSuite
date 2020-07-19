package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveOut;
import pageObjects.Leases.createCharge;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class DraftMoveInTest extends TestBase {
	
	@Test
	public void draftMoveIn() throws IOException, InterruptedException{
	test=extent.createTest("draftMoveIn");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.draftLeases().click();
	EditLease.firstLease().click();
	createCharge.clickLedger().click();
	MoveOut.moveIn().click();
	MoveOut.leaseFeeRefNo().sendKeys("43276");
	MoveOut.paidCheckbox().click();
	MoveOut.toBePrinted().click();
	MoveOut.save().click();
	
	}
}
