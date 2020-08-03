package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.CreateCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.NewLease;
import testBase.TestBase;

public class CreateChargeTest extends TestBase {
	
	//This test will validate the new charge creation for an active lease 
	@Test
	public void createCharge() throws IOException, InterruptedException{
		test=extent.createTest("createCharge");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		NewLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		CreateCharge.clickLedger().click();
		CreateCharge.newCharge().click();
		CreateCharge.selectAccount();
		CreateCharge.chargeRef().sendKeys("1234");
		CreateCharge.amount().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		CreateCharge.amount().sendKeys("250");
		CreateCharge.chargeDate();
		CreateCharge.chargeComment().sendKeys("New charge in lease ledger");
		CreateCharge.saveCharge();
	}
}
