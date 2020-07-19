package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.EmailTenants;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveOut;
import pageObjects.Leases.createCharge;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class EmailTenantsTest extends TestBase {
	
	@Test
	public void emailTenants() throws IOException, InterruptedException{
	test=extent.createTest("emailTenants");
	//Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	EmailTenants.emailTenants().click();
	EmailTenants.selectmultipleTenants();
	EmailTenants.email().click();
	EmailTenants.emailTemplate();
	EmailTenants.body().sendKeys(Keys.chord(Keys.CONTROL, "a"));
	EmailTenants.body().sendKeys("Sample email body for tenant emails");
	//Need to implement attaching file
	//EmailTenants.attachFilesB().click();
	//EmailTenants.file().sendKeys("C:\\Propertyware\\Propertyware Documents\\Sample files\\RentMoneyVoucher.pdf");
	EmailTenants.send().click();
	
	
	}
}
