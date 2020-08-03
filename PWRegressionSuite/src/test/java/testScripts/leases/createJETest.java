package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Adjustments;
import pageObjects.Leases.CreateJE;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class CreateJETest extends TestBase {
	@Test
	public void createNewJE() throws IOException, InterruptedException{
		test=extent.createTest("createNewJE");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		NewLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		Adjustments.clickLedger().click();
		CreateJE.newJE().click();
		CreateJE.ref().sendKeys("je1234");
		CreateJE.comments().sendKeys("Test Journel entry");
		CreateJE.debitAccount();
		CreateJE.debitAmount().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		CreateJE.debitAmount().sendKeys("20");
		CreateJE.creditAccount();
		CreateJE.creditAmount().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		CreateJE.creditAmount().sendKeys("20");
		CreateJE.saveJE();
		
	}
}
