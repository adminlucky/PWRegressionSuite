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

public class CreateDiscountTest extends TestBase {
	
	@Test
	public void createDiscount() throws IOException, InterruptedException{
		test=extent.createTest("createDiscount");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		NewLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		Adjustments.clickLedger().click();
		Adjustments.adjustmentsButton().click();
		Adjustments.discount().click();
		Adjustments.account();
		Adjustments.ref().sendKeys("3217");
		Adjustments.amount().sendKeys(Keys.chord(Keys.CONTROL,"a"));
		Adjustments.amount().sendKeys("-26");
		Adjustments.comment().sendKeys("Discount for testing purpose");
		Adjustments.saveAdj();
			
	}

}
