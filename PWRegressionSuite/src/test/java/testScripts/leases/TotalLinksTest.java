package testScripts.leases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.EmailTenants;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveOut;
import pageObjects.Leases.TotalLinks;
import pageObjects.Leases.createCharge;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class TotalLinksTest extends TestBase {
	
	@Test
	public void totalLinksTest() throws IOException, InterruptedException{
	test=extent.createTest("LeasesTotalLinksTest");
	//Login.refreshPage();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	TotalLinks.draftLeases();
	TotalLinks.evictionLeases();
	TotalLinks.terminatedLeases();
	TotalLinks.noticeGivenLeases();
	newLease.activeLeases().click();	
	}
}
