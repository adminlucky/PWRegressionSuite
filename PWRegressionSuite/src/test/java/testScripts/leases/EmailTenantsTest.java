package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EmailTenants;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class EmailTenantsTest extends TestBase {
	
	@Test
	public void emailTenantsTest() throws IOException, InterruptedException{
	test=extent.createTest("EmailTenantsTest");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	EmailTenants.selectMultipleLeases();
	EmailTenants.emailButton().click();
	EmailTenants.emailTemplate();
	//EmailTenants.subject().sendKeys(Keys.CONTROL, "a");
	//EmailTenants.subject().sendKeys("Tenant emails");
	//EmailTenants.emailBody();
	//Need to implement attaching file
	//EmailTenants.attachFilesB().click();
	//EmailTenants.file().sendKeys("C:\\Propertyware\\Propertyware Documents\\Sample files\\RentMoneyVoucher.pdf");
	//EmailTenants.send();
	
	
	}
}
