package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.Assert;
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


public class MMPrintEnvelopesTest extends TestBase {
	
	@Test
	public void mmPrintEnvelopesTest() throws IOException, InterruptedException{
	test=extent.createTest("MMPrintEnvelopesTest");
	//Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	MailMerge.mailMergeSummary().click();
	String winHandleBefore = driver.getWindowHandle();
	MailMerge.printEnvelopes().click();
	Thread.sleep(4000);
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	    System.out.println("Switched to remote window : "+driver.getCurrentUrl());
	}
	Boolean flag = driver.getCurrentUrl().contains("action=PrintEnvelopes");
	//Boolean flag = driver.getTitle().contains("action=PrintEnvelopes");
	System.out.println("flag value is : "+flag);
	if(flag) {
		System.out.println("Verified url");
		driver.close();
		Assert.assertTrue(flag, "PrintEnvelopes action failed");
	}
	else
		driver.close();
	driver.switchTo().window(winHandleBefore);
	System.out.println("Switched to remote window");
	MailMerge.done().click();
	
	}
}
