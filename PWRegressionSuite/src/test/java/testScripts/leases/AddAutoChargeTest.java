package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class AddAutoChargeTest extends TestBase {
	
	@Test
	public void addAutoCharge() throws IOException{
	test=extent.createTest("addAutoCharge");
	initialization();
	newLease.leases().click();
	newLease.activeLeases().click();
	MoveoutAndTerminateLease.firstActiveLease().click();
	EditLease.edit().click();
	AddAutoCharge.newAutoCharge().click();
	AddAutoCharge.startDate();
	AddAutoCharge.amount().sendKeys(Keys.chord(Keys.CONTROL, "a"),"600");
	AddAutoCharge.desc().sendKeys("Monthly Rent auto charge");
	AddAutoCharge.save().click();
	EditLease.save().click();	
	}
}
