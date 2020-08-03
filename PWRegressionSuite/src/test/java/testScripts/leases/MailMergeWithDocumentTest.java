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


public class MailMergeWithDocumentTest extends TestBase {
	
	@Test
	public void mailMergeWithTemplateTest() throws IOException, InterruptedException{
	test=extent.createTest("MailMergeWithTemplateTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	MailMerge.mailMergeSummary().click();
	MailMerge.selectMMDocument().click();
	MailMerge.emailThisDoc().click();
	//MailMerge.selectEmailTemplate();
	MailMerge.mmEmailSubject().sendKeys("Mail Merge document with eSig tags test");
	MailMerge.mmEmailBody().sendKeys("This test is to verify the Mail Merge document with eSig tags functionality");
	MailMerge.send();
	MailMerge.done().click();
	
	}
}
