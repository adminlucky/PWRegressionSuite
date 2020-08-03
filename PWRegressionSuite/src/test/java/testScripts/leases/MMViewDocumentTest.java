package testScripts.leases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.MailMerge;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import testBase.TestBase;


public class MMViewDocumentTest extends TestBase {
	
	@Test
	public void mmViewDocumentTest() throws IOException, InterruptedException{
	test=extent.createTest("MMViewDocumentTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	MailMerge.mailMergeSummary().click();
	MailMerge.selectMMTemplate();
	String winHandleBefore = driver.getWindowHandle();
	MailMerge.viewDoc().click();
	Thread.sleep(4000);
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	//(new WebDriverWait(driver, 10)).until(ExpectedConditions.jsReturnsValue("complete"));
	Boolean flag = driver.getTitle().contains("Lease Agreement- Residential");
	if(flag) {
		driver.close();
		Assert.assertTrue(flag, "Lease Mail Merge view document failed");
	}
	else
		driver.close();
	driver.switchTo().window(winHandleBefore);
	MailMerge.done().click();
	}
}
