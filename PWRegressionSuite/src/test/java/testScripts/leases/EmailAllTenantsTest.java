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


public class EmailAllTenantsTest extends TestBase {
	
	@Test
	public void emailAllTenants() throws IOException, InterruptedException{
	test=extent.createTest("emailAllTenants");
	//Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	EmailTenants.emailTenants().click();
	EmailTenants.selectmultipleTenants();
	EmailTenants.email().click();
	EmailTenants.emailTemplate();
	
	EmailTenants.bodyTemplate();
	
	//Need to implement attaching file
	//EmailTenants.attachFilesB().click();
	//EmailTenants.file().sendKeys("C:\\Propertyware\\Propertyware Documents\\Sample files\\RentMoneyVoucher.pdf");
	EmailTenants.send();
	
	
	}
}
