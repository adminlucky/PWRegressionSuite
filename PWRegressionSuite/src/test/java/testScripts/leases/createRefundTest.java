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

public class CreateRefundTest extends TestBase {
	
	@Test
	public void createRefund() throws IOException, InterruptedException{
		test=extent.createTest("createRefund");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		NewLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		Adjustments.clickLedger().click();
		Adjustments.adjustmentsButton().click();
		Adjustments.refund().click();
		Adjustments.payFrom();
		Adjustments.amount().sendKeys(Keys.chord(Keys.CONTROL,"a"));
		Adjustments.amount().sendKeys("-5");
		Adjustments.comment().sendKeys("Refund for testing purpose");
		Adjustments.saveAdj();
	}

}
