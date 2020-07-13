package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.GenerateCRPs;
import pageObjects.Leases.Login;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class GenerateCRPsWisconsinTest extends TestBase {
	
	@Test
	public void generateCRPsWisconsin() throws IOException, InterruptedException{
	test=extent.createTest("generateCRPsWisconsin");
	Login.refreshPage();
	Login.homePage().click();
	newLease.leases().click();
	newLease.activeLeases().click();
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
