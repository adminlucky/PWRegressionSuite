package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.GenerateCRPs;
import pageObjects.Leases.Login;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class GenerateCRPsMinnesotaTest extends TestBase {
	
	@Test
	public void generateCRPsMinnesota() throws IOException, InterruptedException{
	test=extent.createTest("generateCRPsMinnesota");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	GenerateCRPs.createdDateLink().click();
	GenerateCRPs.sortAtoZ().click();
	EditLease.firstLease().click();
	String date = GenerateCRPs.startDate().getText();
	String yearCRP = (date.substring(date.length() - 5)).trim();
	GenerateCRPs.generateCRP().click();
	GenerateCRPs.stateMinnesota();
	GenerateCRPs.year(yearCRP);
	GenerateCRPs.contact().click();
	GenerateCRPs.attachToLeaseDocs().click();
	GenerateCRPs.done().click();
	}
	
}
