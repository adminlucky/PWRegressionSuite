package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.StickyNote;
import pageObjects.Leases.createCharge;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class EditStickyNoteTest extends TestBase {
	
	@Test
	public void editStickyNote() throws IOException, InterruptedException{
	test=extent.createTest("editStickyNote");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	createCharge.clickLedger().click();
	StickyNote.viewButton().click();
	StickyNote.editNote().click();
	StickyNote.noteBody().sendKeys(Keys.END, " - Sticky note updated");
	StickyNote.saveNote();
	
	}
}
