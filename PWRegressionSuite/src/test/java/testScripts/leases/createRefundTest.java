package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.adjustments;
import pageObjects.Leases.newLease;
import testBase.TestBase;

public class CreateRefundTest extends TestBase {
	
	@Test
	public void createRefund() throws IOException, InterruptedException{
		test=extent.createTest("createRefund");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		newLease.leases().click();
		newLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		adjustments.clickLedger().click();
		adjustments.adjustmentsButton().click();
		adjustments.refund().click();
		adjustments.payFrom();
		adjustments.amount().sendKeys(Keys.chord(Keys.CONTROL,"a"));
		adjustments.amount().sendKeys("-5");
		adjustments.comment().sendKeys("Refund for testing purpose");
		adjustments.saveAdj();
	}

}
