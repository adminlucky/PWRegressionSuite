package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.EmailTenants;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveOut;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.createCharge;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class LeasesEmailTest extends TestBase {
	
	@Test
	public void leasesEmailTest() throws IOException, InterruptedException{
	test=extent.createTest("LeasesEmailTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	EmailTenants.selectMultipleLeases();
	EmailTenants.emailButton().click();
	EmailTenants.emailTemplate();
	//EmailTenants.subject().sendKeys(Keys.chord(Keys.CONTROL, "a"));
	//EmailTenants.subject().sendKeys("Tenant emails");
	EmailTenants.subject();
	EmailTenants.emailBody();
	//Need to implement attaching file
	//EmailTenants.attachFilesB().click();
	//EmailTenants.attachFilesB().sendKeys("C:\\RAMAKRISHNA\\Propertyware\\Propertyware Documents\\Sample files\\RentMoneyVoucher.pdf");
	EmailTenants.send();
	
	
	}
}
