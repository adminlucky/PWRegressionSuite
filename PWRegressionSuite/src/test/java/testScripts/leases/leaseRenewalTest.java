package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Leases.leaseRenewal;
import testBase.TestBase;

public class leaseRenewalTest extends TestBase{
	@Test
	public void leaseRenewal() throws IOException{
		test=extent.createTest("leaseRenewal");
		initialization();
		//UtilityMethods.waitForElementToLoad(driver, "//a[contains(text(),'Leases')]");
		driver.findElement(By.xpath("//a[contains(text(),'Leases')]")).click();
		driver.findElement(By.xpath("//a[@href=\"javascript:showTerminated( 'Terminated' );\"]")).click();
		leaseRenewal.firstTerminatedLease().click();
		leaseRenewal.renewalLease().click();
		//test.createNode("Lease renewal link clicked","Dates popup window will be opened");
		leaseRenewal.newStartDate();
		leaseRenewal.renewedDate();
		leaseRenewal.newEndDate();
		//leaseRenewal.save();
		boolean save = leaseRenewal.save().isDisplayed();
		Assert.assertTrue(save);
		test.createNode("Save button displayed");
		Assert.assertFalse(save);
		test.createNode("Save button not displayed");
	}
}
