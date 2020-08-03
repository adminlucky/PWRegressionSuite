package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.MiscObjects;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.adjustments;
import pageObjects.Leases.createJE;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class FilterTest extends TestBase {
	@Test
	public void filterTest() throws IOException, InterruptedException{
		//This test is to filter the leases by portfolio
		test=extent.createTest("FilterTest");
		//Login.refreshPage();
		AddAutoCharge.waitForLeases();
		newLease.leases().click();
		MiscObjects.selectPortfolio();
		
		
	}
}
