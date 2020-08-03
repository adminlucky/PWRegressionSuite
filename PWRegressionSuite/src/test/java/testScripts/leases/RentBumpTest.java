package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.DeleteLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.RentBump;
import testBase.TestBase;


public class RentBumpTest extends TestBase {
	
	@Test
	public void rentBump() throws IOException, InterruptedException{
	test=extent.createTest("rentBump");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	DeleteLease.firstLeaseCheckbox().click();
	RentBump.rentBump().click();
	//RentBump.rentBumpType().click();
	RentBump.rentBumpPercentage().sendKeys(Keys.chord(Keys.CONTROL, "a"));
	RentBump.rentBumpPercentage().sendKeys("10");
	RentBump.save().click();
	RentBump.done().click();
	
	}
}
