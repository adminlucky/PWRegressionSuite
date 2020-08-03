package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EmailTenants;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class EmailAllTenantsTest extends TestBase {
	
	@Test
	public void emailAllTenants() throws IOException, InterruptedException{
	test=extent.createTest("emailAllTenants");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	EmailTenants.emailAllTenants().click();
	EmailTenants.selectmultipleTenants();
	EmailTenants.email().click();
	EmailTenants.emailTemplate();
	EmailTenants.subject();
	EmailTenants.emailBody();
	
	//Need to implement attaching file
	//EmailTenants.attachFilesB().click();
	//EmailTenants.file().sendKeys("C:\\Propertyware\\Propertyware Documents\\Sample files\\RentMoneyVoucher.pdf");
	//EmailTenants.send();
	
	
	}
}
