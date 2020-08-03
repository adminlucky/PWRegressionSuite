package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.LeaseConversations;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import testBase.TestBase;
import utilities.UtilityMethods;


public class LeaseTenantConvTest extends TestBase {
	
	@Test
	public void leaseTenantConversation() throws IOException, InterruptedException{
	test=extent.createTest("leaseTenantConversation");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	UtilityMethods.scrollDownHalf(driver);
	LeaseConversations.conversationsTab().click();
	LeaseConversations.tenantConversation();
	String tenantComment = "Tenant conversation from Leases module for testing purpose";
	LeaseConversations.comments().sendKeys(tenantComment);
	LeaseConversations.share().click();
	
	LeaseConversations.clickTenant().click();
	UtilityMethods.scrollDownHalf(driver);
	LeaseConversations.portalTab().click();
	LeaseConversations.tenantLoginAs().click();
	String winHandleBefore = driver.getWindowHandle();
	LeaseConversations.verifyTenantConversation(tenantComment);
	driver.switchTo().window(winHandleBefore);
	
	}
}
