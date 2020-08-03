package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.Login;
import pageObjects.Leases.MailMerge;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class LeaseMailMergeNegativeTest extends TestBase {
	
	@Test
	public void leaseMailMergeNegativeTest() throws IOException, InterruptedException{
	test=extent.createTest("LeaseMailMergeNegativeTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	MailMerge.mailMergeHome().click();
	MailMerge.validateMMNegative();
	}
}
