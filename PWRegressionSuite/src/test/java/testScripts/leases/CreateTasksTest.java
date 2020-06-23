package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.CreateTasks;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class CreateTasksTest extends TestBase {
	
	@Test
	public void createSingleTask() throws IOException{
	test=extent.createTest("createSingleTask");
	initialization();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink().click();
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
	
	@Test
	public void createTasksFromTemplate() throws IOException{
	test=extent.createTest("createTasksFromTemplate");
	initialization();
	newLease.leases().click();
	newLease.activeLeases().click();
	EditLease.firstLease().click();
	NewLeaseFromLeasePage.leaseSummaryLink().click();
	CreateTasks.tasksTab().click();
	CreateTasks.loadFromTemplate().click();
	CreateTasks.selectTemplate();
	CreateTasks.deligate().click();
	CreateTasks.deligateName().click();;
	CreateTasks.saveDeligateName().click();
	CreateTasks.createTasks().click();
	}
	
	
}
