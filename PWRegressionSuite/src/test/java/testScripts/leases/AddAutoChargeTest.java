package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import testBase.TestBase;

public class AddAutoChargeTest extends TestBase {
	
	@Test
	public void addAutoCharge() throws IOException, InterruptedException{
	test=extent.createTest("addAutoCharge");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	AddAutoCharge.changeTimeout();
	NewLease.activeLeases().click();
	MoveoutAndTerminateLease.firstActiveLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	EditLease.edit();
	AddAutoCharge.newAutoCharge().click();
	AddAutoCharge.startDate();
	AddAutoCharge.amount().sendKeys(Keys.chord(Keys.CONTROL, "a"));
	AddAutoCharge.amount().sendKeys("800");
	AddAutoCharge.desc().sendKeys("Monthly Rent auto charge");
	AddAutoCharge.saveAutoCharge();
	EditLease.saveLease();	
	
	}
}
