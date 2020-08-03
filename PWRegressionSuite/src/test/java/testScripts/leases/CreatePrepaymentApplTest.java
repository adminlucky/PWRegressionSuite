package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.createPayment;
import pageObjects.Leases.newLease;
import testBase.TestBase;

public class CreatePrepaymentApplTest extends TestBase {

	@Test
	public void createPrepaymentApplTest() throws IOException, InterruptedException{
		test=extent.createTest("CreatePrepaymentApplTest");
		//Login.refreshPage();
		AddAutoCharge.waitForLeases();
		newLease.leases().click();
		newLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		createPayment.ledger().click();
		createPayment.newPayment().click();
		createPayment.ref().sendKeys("13367");
		createPayment.comment().sendKeys("Test for prepayment application creation");
		//Creating prepayment application
		createPayment.prepayAmount().sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		createPayment.prepayAmount().sendKeys("$25");
		createPayment.savePayment().click();
		createPayment.confirmPrepay();
		
	}
}
