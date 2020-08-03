package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.DeleteLease;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.MailMerge;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.RentBump;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class MMEmailThisDocNegativeTest extends TestBase {
	
	@Test
	public void mmEmailThisDocNegativeTest() throws IOException, InterruptedException{
	test=extent.createTest("MMEmailThisDocNegativeTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	MailMerge.mailMergeSummary().click();
	MailMerge.emailThisDoc().click();
	MailMerge.validateDocSelection();
	
	}
}
