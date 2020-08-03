package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.MailMerge;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import testBase.TestBase;


public class MMAttachToLeaseNegativeTest extends TestBase {
	
	@Test
	public void mmAttachToLeaseNegativeTest() throws IOException, InterruptedException{
	test=extent.createTest("MMAttachToLeaseNegativeTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	MailMerge.mailMergeSummary().click();
	MailMerge.attachToLease().click();
	MailMerge.validateDocSelection();
	
	}
}
