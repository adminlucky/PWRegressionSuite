package testScripts.leases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.TotalLinks;
import testBase.TestBase;


public class TotalLinksTest extends TestBase {
	
	@Test
	public void totalLinksTest() throws IOException, InterruptedException{
	test=extent.createTest("LeasesTotalLinksTest");
	Login.refreshPage();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	TotalLinks.draftLeases();
	TotalLinks.evictionLeases();
	TotalLinks.terminatedLeases();
	TotalLinks.noticeGivenLeases();
	NewLease.activeLeases().click();	
	}
}
