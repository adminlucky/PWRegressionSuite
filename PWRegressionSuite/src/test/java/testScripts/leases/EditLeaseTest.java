package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class EditLeaseTest extends TestBase {
	
	//Editing lease details and making lease Evicted
	@Test
	public void editLease() throws IOException, InterruptedException{
	test=extent.createTest("editLease");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	EditLease.edit().click();
	EditLease.activeToEviction();
	EditLease.publicAssistance();
	//text overwrite
	//EditLease.description().sendKeys(Keys.chord(Keys.CONTROL, "a"), "Description updated");	
	//text append
	EditLease.description().sendKeys(Keys.END, " - Lease status changed from Active to Eviction");
	EditLease.saveEviction();
	EditLease.restrictionsSave();
	}
}
