package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.LeasesMassUpdate;
import pageObjects.Leases.Login;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class MassUpdateTest extends TestBase {
	@Test
	public void leasesMassUpdate() throws IOException, InterruptedException{
		test=extent.createTest("leasesMassUpdate");
		Login.refreshPage();
		AddAutoCharge.waitForLeases();
		newLease.leases().click();
		LeasesMassUpdate.gridEdit().click();
		LeasesMassUpdate.massUpdate().click();
		LeasesMassUpdate.column();
		LeasesMassUpdate.newValue().sendKeys("Health Issues");
		LeasesMassUpdate.submit();
		LeasesMassUpdate.ok();
		
	}
}
