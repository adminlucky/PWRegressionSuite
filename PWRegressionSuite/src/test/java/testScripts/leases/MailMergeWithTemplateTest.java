package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.DeleteLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.MailMerge;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class MailMergeWithTemplateTest extends TestBase {
	
	@Test
	public void mailMergeWithTemplateTest() throws IOException, InterruptedException{
	test=extent.createTest("MailMergeWithTemplateTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	DeleteLease.firstLeaseCheckbox().click();
	MailMerge.mailMergeHome().click();
	MailMerge.selectMMTemplate();
	MailMerge.emailThisDoc().click();
	MailMerge.selectEmailTemplate();
	MailMerge.send();
	MailMerge.done().click();
	
	}
}
