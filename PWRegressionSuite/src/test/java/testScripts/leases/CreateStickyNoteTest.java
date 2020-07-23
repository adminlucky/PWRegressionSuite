package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.StickyNote;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class CreateStickyNoteTest extends TestBase {
	
	@Test
	public void createStickyNote() throws IOException, InterruptedException{
	test=extent.createTest("createStickyNote");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	StickyNote.setButton().click();
	StickyNote.noteBody().sendKeys("Leases Sticky note for testing purpose");
	StickyNote.saveNote();
	
	}
}
