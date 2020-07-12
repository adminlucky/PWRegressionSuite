package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.EditLease;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class DraftToActiveTest extends TestBase {
	
	@Test
	public void editLease() throws IOException{
	test=extent.createTest("editLease");
	initialization();
	newLease.leases().click();
	newLease.draftLeases().click();
	EditLease.firstLease().click();
	EditLease.edit().click();
	EditLease.draftToActive();
	EditLease.publicAssistance();
	EditLease.description().sendKeys(Keys.END, " - Draft lease converted to active lease");
	EditLease.scheduleInspection().click();
	EditLease.inspectionStartDate();	//Need to improve
	EditLease.costEstimate().sendKeys(Keys.chord(Keys.CONTROL, "a"),"$40");
	EditLease.inspectionDesc().sendKeys("Sample Inspection");
	EditLease.save();
	newLease.cancel();
	
	}
}
