package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.NotesAndDocs;
import testBase.TestBase;


public class CreateNoteTest extends TestBase {
	
	@Test
	public void createNote() throws IOException, InterruptedException{
	test=extent.createTest("createNote");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	NotesAndDocs.notesAndDocsTab().click();
	NotesAndDocs.attachNote().click();
	NotesAndDocs.subject().sendKeys("Note Subject");
	NotesAndDocs.privateNote().click();
	NotesAndDocs.noteDate();
	NotesAndDocs.body().sendKeys("Private note body for testing");
	NotesAndDocs.saveNote().click();
	
	}
}
