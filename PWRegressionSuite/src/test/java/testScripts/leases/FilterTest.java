package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.MiscObjects;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class FilterTest extends TestBase {
	@Test
	public void filterTest() throws IOException, InterruptedException{
		//This test is to filter the leases by portfolio
		test=extent.createTest("FilterTest");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		NewLease.leases().click();
		MiscObjects.selectPortfolio();
		
		
	}
}
