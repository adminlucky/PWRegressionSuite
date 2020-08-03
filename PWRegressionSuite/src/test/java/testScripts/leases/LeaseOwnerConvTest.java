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


public class LeaseOwnerConvTest extends TestBase {
	
	@Test
	public void leaseOwnerConversation() throws IOException, InterruptedException{
	test=extent.createTest("leaseOwnerConversation");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	UtilityMethods.scrollDownHalf(driver);
	LeaseConversations.conversationsTab().click();
	LeaseConversations.ownerConversation();
	String ownerComment = "Owner conversation from Leases module for testing purpose";
	LeaseConversations.comments().sendKeys(ownerComment);
	LeaseConversations.share().click();
	/*
	LeaseConversations.clickBuilding().click();
	LeaseConversations.clickOwner().click();
	UtilityMethods.scrollDownHalf(driver);
	LeaseConversations.portalTab().click();
	LeaseConversations.ownerLoginAs().click();
	String winHandleBefore = driver.getWindowHandle();
	LeaseConversations.verifyOwnerConversation(ownerComment);
	driver.switchTo().window(winHandleBefore);*/
	
	}
}
