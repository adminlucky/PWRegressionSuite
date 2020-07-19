package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class MoveoutAndTerminateLeaseTest extends TestBase {

	@Test
	public void moveoutAndTerminateLease() throws IOException, InterruptedException{
		test=extent.createTest("moveoutAndTerminateLease");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		newLease.leases().click();
		newLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		MoveoutAndTerminateLease.moveOutLink().click();
		MoveoutAndTerminateLease.startCalendar();
		MoveoutAndTerminateLease.reason();
		//MoveoutAndTerminateLease.disablePortal().click();
		MoveoutAndTerminateLease.comment().sendKeys("Terminating lease");
		MoveoutAndTerminateLease.save().click();
	}
}
