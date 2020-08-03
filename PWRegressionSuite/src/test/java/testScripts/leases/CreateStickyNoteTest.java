package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.StickyNote;
import testBase.TestBase;


public class CreateStickyNoteTest extends TestBase {
	
	@Test
	public void createStickyNote() throws IOException, InterruptedException{
	test=extent.createTest("createStickyNote");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	StickyNote.setButton().click();
	StickyNote.noteBody().sendKeys("Leases Sticky note for testing purpose");
	StickyNote.saveNote();
	
	}
}
