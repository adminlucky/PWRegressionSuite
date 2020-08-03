package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Adjustments;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class CreateAdjustmentTest extends TestBase {
	
	@Test
	public void createAdjustment() throws IOException, InterruptedException{
		test=extent.createTest("createAdjustment");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		NewLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		Adjustments.clickLedger().click();
		Adjustments.adjustmentsButton().click();
		Adjustments.adjustment().click();
		Adjustments.ref().sendKeys("6734");
		Adjustments.amount().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		Adjustments.amount().sendKeys("21");
		Adjustments.comment().sendKeys("Adjustment for testing purpose");
		Adjustments.saveAdj();
	}
	
}
