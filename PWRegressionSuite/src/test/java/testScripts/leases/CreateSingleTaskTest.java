package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.CreateTasks;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class CreateSingleTaskTest extends TestBase {
	
	@Test
	public void createSingleTask() throws IOException, InterruptedException{
	test=extent.createTest("createSingleTask");
	Login.refreshPage();
	AddAutoCharge.waitForLeases();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink();
	CreateTasks.tasksTab().click();
	CreateTasks.newTask().click();
	CreateTasks.taskDesc().sendKeys("Single task created from lease");
	CreateTasks.dueDate();	// Need improvement
	CreateTasks.deligateInput().click();
	CreateTasks.deligatePerson().click();
	CreateTasks.saveDeligate().click();
	CreateTasks.privateOrPublic().click();
	CreateTasks.saveTask().click();
	}
	
}
