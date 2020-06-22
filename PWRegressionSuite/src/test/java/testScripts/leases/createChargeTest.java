package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.createCharge;
import pageObjects.Leases.newLease;
import testBase.TestBase;

public class createChargeTest extends TestBase {
	
	//This test will validate the new charge creation for an active lease 
	@Test
	public void createCharge() throws IOException{
		test=extent.createTest("createCharge");
		initialization();
		newLease.leases().click();
		newLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		createCharge.clickLedger().click();
		createCharge.newCharge().click();
		createCharge.selectAccount();
		createCharge.chargeRef().sendKeys("1234");
		createCharge.amount().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		createCharge.amount().sendKeys("250");
		createCharge.chargeDate();
		createCharge.chargeComment().sendKeys("New charge in lease ledger");
		createCharge.saveCharge().click();
	}
}
