package testScripts.leases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.Leases.CreateTasks;
import pageObjects.Leases.EditLease;
import pageObjects.Leases.Login;
import pageObjects.Leases.NewLeaseFromLeasePage;
import pageObjects.Leases.newLease;
import testBase.TestBase;


public class CreateTasksFromTemplateTest extends TestBase {
	
	@Test
	public void createTasksFromTemplate() throws IOException, InterruptedException{
	test=extent.createTest("createTasksFromTemplate");
	Login.refreshPage();
	Login.homePage().click();
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
