package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.LeaseConversations;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;

public class LeaseMgmtConvTest extends TestBase {
	
	@Test
	public void leaseMgmtConvTest() throws IOException, InterruptedException{
	test=extent.createTest("LeaseMgmtConvTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	UtilityMethods.scrollDownHalf(driver);
	LeaseConversations.conversationsTab().click();
	LeaseConversations.mgmtConversation();
	String mgmtComment = "Management conversation from Leases module for testing purpose";
	LeaseConversations.comments().sendKeys(mgmtComment);
	LeaseConversations.share().click();
	/*
	UtilityMethods.scrollUpHalf(driver);
	LeaseConversations.switchToDesktop().click();
	UtilityMethods.scrollDownHalf(driver);
	LeaseConversations.filterMgmtConversations();
	LeaseConversations.verifyMgmtConversation(mgmtComment);
	*/
	}
}
