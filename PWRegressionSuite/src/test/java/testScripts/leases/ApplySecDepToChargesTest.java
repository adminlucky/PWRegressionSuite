package testScripts.leases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.ApplySecDepCharges;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.LeaseLedger;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import testBase.TestBase;

public class ApplySecDepToChargesTest extends TestBase {
	
	@Test
	public void applySecDepToCharges() throws IOException, InterruptedException{
	test=extent.createTest("applySecDepToCharges");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	NewLease.leases().click();
	NewLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.ledger().click();
	LeaseLedger.applySecDepToCharges().click();
	boolean flag = ApplySecDepCharges.checkUnpaidChargesExist();
		if(flag){
			String due = ApplySecDepCharges.amountDue().getText();
			ApplySecDepCharges.amount().sendKeys(due);
		}
		else
			Assert.assertEquals(false, "No unpaid charges present in the lease ledger");
		
		ApplySecDepCharges.applySave().click();
	
	}
}
