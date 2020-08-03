package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.GenerateCRPs;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import testBase.TestBase;


public class GenerateCRPsWisconsinTest extends TestBase {
	
	@Test
	public void generateCRPsWisconsin() throws IOException, InterruptedException{
	test=extent.createTest("generateCRPsWisconsin");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	GenerateCRPs.createdDateLink().click();
	GenerateCRPs.sortAtoZ().click();
	EditLease.firstLease().click();
	String date = GenerateCRPs.startDate().getText();
	String yearCRP = (date.substring(date.length() - 5)).trim();
	GenerateCRPs.generateCRP().click();
	GenerateCRPs.stateWisconsin();
	GenerateCRPs.year(yearCRP);
	GenerateCRPs.contact().click();
	GenerateCRPs.attachToLeaseDocs().click();
	GenerateCRPs.done().click();
	}
	
}
