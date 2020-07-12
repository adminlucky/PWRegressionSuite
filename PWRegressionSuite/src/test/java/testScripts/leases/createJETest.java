package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.adjustments;
import pageObjects.Leases.createJE;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class createJETest extends TestBase {
	@Test
	public void createNewJE() throws IOException, InterruptedException{
		test=extent.createTest("createNewJE");
		//initialization();
		Login.refreshPage();
		Login.homePage().click();
		newLease.leases().click();
		newLease.activeLeases().click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		adjustments.clickLedger().click();
		createJE.newJE().click();
		createJE.ref().sendKeys("je1234");
		createJE.comments().sendKeys("Test Journel entry");
		createJE.debitAccount();
		createJE.debitAmount().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		createJE.debitAmount().sendKeys("20");
		createJE.creditAccount();
		createJE.creditAmount().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		createJE.creditAmount().sendKeys("20");
		createJE.saveJE();
		
		
	}
}
