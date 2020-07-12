package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.adjustments;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class createAdjustmentTest extends TestBase {
	
	@Test
	public void createAdjustment() throws IOException{
		test=extent.createTest("createAdjustment");
		initialization();
		newLease.leases().click();
		newLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		adjustments.clickLedger().click();
		adjustments.adjustmentsButton().click();
		adjustments.adjustment().click();
		adjustments.ref().sendKeys("6734");
		adjustments.amount().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		adjustments.amount().sendKeys("21");
		adjustments.comment().sendKeys("Adjustment for testing purpose");
		adjustments.save().click();
	}
	
}
