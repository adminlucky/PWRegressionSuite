package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.CreatePayment;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.NewLease;
import testBase.TestBase;

public class CreatePrepaymentApplTest extends TestBase {

	@Test
	public void createPrepaymentApplTest() throws IOException, InterruptedException{
		test=extent.createTest("CreatePrepaymentApplTest");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		NewLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		CreatePayment.ledger().click();
		CreatePayment.newPayment().click();
		CreatePayment.ref().sendKeys("13367");
		CreatePayment.comment().sendKeys("Test for prepayment application creation");
		//Creating prepayment application
		CreatePayment.prepayAmount().sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		CreatePayment.prepayAmount().sendKeys("$25");
		CreatePayment.savePayment().click();
		CreatePayment.confirmPrepay();
		
	}
}
