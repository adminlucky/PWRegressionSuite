package testScripts.leases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Leases.EditLease;
import pageObjects.Leases.LeaseLedger;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import testBase.TestBase;

public class PrintLeaseLedger extends TestBase {
	
	@Test
	public void printLeaseLedger() throws IOException{
	test=extent.createTest("printLeaseLedger");
	initialization();
	newLease.leases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.ledger().click();
	LeaseLedger.printLedger().click();
	
	//String winHandleBefore = driver.getWindowHandle();
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	//driver.close();
	LeaseLedger.closeWindow().click();
	
	//driver.switchTo().window(winHandleBefore);
	
	}
}
