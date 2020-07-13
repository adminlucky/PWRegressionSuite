package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.Leases.DeleteLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.RentBump;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class RentBumpTest extends TestBase {
	
	@Test
	public void rentBump() throws IOException, InterruptedException{
	test=extent.createTest("rentBump");
	Login.refreshPage();
	Login.homePage().click();
	newLease.leases().click();
	newLease.activeLeases().click();
	DeleteLease.firstLeaseCheckbox().click();
	RentBump.rentBump().click();
	RentBump.rentBumpType().click();
	RentBump.rentBumpAmount().sendKeys(Keys.chord(Keys.CONTROL, "a"),"$100");
	RentBump.save().click();
	RentBump.done().click();
	
	}
}
