package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.adjustments;
import pageObjects.Leases.clearUnpaidCharges;
import testBase.TestBase;

public class clearUnpaidChargesTest extends TestBase {
	@Test
	public void clearUnpaidCharges() throws IOException{
		test=extent.createTest("clearUnpaidCharges");
		initialization();
		driver.findElement(By.xpath("//a[contains(text(),'Leases')]")).click();
		driver.findElement(By.xpath("//a[@href=\"javascript:showActive('Active');\"]a")).click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		adjustments.clickLedger().click();
		clearUnpaidCharges.clearUnpaid().click();
		clearUnpaidCharges.ok();
	}
}
