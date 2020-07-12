package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import dataReader.Excel_Reader;
import pageObjects.Leases.newLease;
import pageObjects.Leases.newLeaseWithLeaseForm;
import testBase.TestBase;
import utilities.UtilityMethods;

public class newLeaseWithLFAndExistingContactTest extends TestBase {

Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createLeaseWithLFAndExistingContact() throws IOException, InterruptedException{
		test=extent.createTest("createLeaseWithLFAndExistingContact");
		initialization();
		String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
		UtilityMethods.waitForElementToLoad(driver, "//a[contains(text(),'Leases')]");
		driver.findElement(By.xpath("//a[contains(text(),'Leases')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New Lease')]")).click();
		newLeaseWithLeaseForm.leaseForm();
		UtilityMethods.waitForElementToLoad(driver, "//input[@name='leaseInspectionStartDateAsString']");
		newLeaseWithLeaseForm.location().click();
		newLeaseWithLeaseForm.selectLocation().click();
		newLeaseWithLeaseForm.done().click();
		//UtilityMethods.waitForElementToBeInvisible(driver, "//div[@id='attachUnitForm']");
		newLeaseWithLeaseForm.startCalendar();
		newLeaseWithLeaseForm.endDate();
		newLeaseWithLeaseForm.publicAssistance();
		//newLeaseWithLeaseForm.addContactButton().click();
		newLease.addContactButton();
		newLeaseWithLeaseForm.createNewContactButton().click();
		String fname=xlReader.readExcel(driver,filepath,"Leases",1,0);
		newLeaseWithLeaseForm.firstname().sendKeys(fname);
		String lname=xlReader.readExcel(driver,filepath,"Leases",1,1);
		newLeaseWithLeaseForm.lastname().sendKeys(lname);
		String email=xlReader.readExcel(driver,filepath,"Leases",1,2);
		newLeaseWithLeaseForm.email().sendKeys(email);
		newLeaseWithLeaseForm.saveNewContact().click();
		UtilityMethods.waitForElementToLoad(driver, "//div[7]//input[1]");
		UtilityMethods.scrollDown(driver);
		newLeaseWithLeaseForm.inspectionStartDate();
		newLeaseWithLeaseForm.saveLease().click();
		UtilityMethods.waitForElementToLoad(driver, "//form[1]/div[10]/div[3]/input[2]");
		newLeaseWithLeaseForm.cancel().click();
	}
}
