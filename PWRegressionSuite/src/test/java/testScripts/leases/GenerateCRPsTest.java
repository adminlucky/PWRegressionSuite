package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.GenerateCRPs;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class GenerateCRPsTest extends TestBase {
	
	@Test
	public void generateCRPsMinnesota() throws IOException{
	test=extent.createTest("generateCRPsMinnesota");
	initialization();
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
	
	@Test
	public void generateCRPsWisconsin() throws IOException{
	test=extent.createTest("generateCRPsWisconsin");
	initialization();
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
