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

public class CreatePaymentTest extends TestBase {

	@Test
	public void createPayment() throws IOException, InterruptedException{
		test=extent.createTest("createPayment");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		NewLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		CreatePayment.ledger().click();
		CreatePayment.newPayment().click();
		CreatePayment.ref().sendKeys("3214");
		CreatePayment.comment().sendKeys("Test for payment creation");
		//Selecting unpaid charge or making prepayment
		if(driver.getPageSource().contains("No Outstanding Charges"))
		{
			CreatePayment.prepayAmount().sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			CreatePayment.prepayAmount().sendKeys("$150");
			CreatePayment.savePayment().click();
			driver.switchTo().alert().accept();
		}
		else{
			CreatePayment.selectUnpaidCharge().click();
			CreatePayment.savePayment().click();
		}
		
		
	}
}
