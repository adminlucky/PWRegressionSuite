package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.LeaseLedger;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import testBase.TestBase;

public class PrintLeaseLedger extends TestBase {
	
	@Test
	public void printLeaseLedger() throws IOException, InterruptedException{
	test=extent.createTest("printLeaseLedger");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.ledger().click();
	LeaseLedger.printLedger().click();
	
	String winHandleBefore = driver.getWindowHandle();
	for(String winHandle : driver.getWindowHandles()){
	    driver.switchTo().window(winHandle);
	}
	LeaseLedger.closeWindow().click();
	
	driver.switchTo().window(winHandleBefore);
	
	}
}
