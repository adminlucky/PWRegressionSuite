package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.EditLease;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class EditLeaseTest extends TestBase {
	
	@Test
	public void editLease() throws IOException{
	test=extent.createTest("editLease");
	initialization();
	newLease.leases().click();
	newLease.activeLeases().click();
	MoveoutAndTerminateLease.firstActiveLease().click();
	EditLease.edit().click();
	EditLease.activeToEviction();
	EditLease.publicAssistance();
	//text overwrite
	//EditLease.description().sendKeys(Keys.chord(Keys.CONTROL, "a"), "Description updated");	
	//text append
	EditLease.description().sendKeys(Keys.END, " - Lease status changed from Active to Eviction");
	EditLease.save().click();
	EditLease.restrictionsSave().click();
	}
}
