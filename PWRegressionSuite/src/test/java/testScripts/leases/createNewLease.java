package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import dataReader.Excel_Reader;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;


public class createNewLease extends TestBase {
	
	Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createLease() throws IOException, InterruptedException{
		initialization();
		String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
		UtilityMethods.waitForElementToLoad(driver, "//a[contains(text(),'Leases')]");
		driver.findElement(By.xpath("//a[contains(text(),'Leases')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New Lease')]")).click();
		newLease.location().click();
		newLease.selectLocation().click();
		UtilityMethods.waitForElementToBeClickable(driver, "//div[@id='attachUnitForm']//div[@class='primaryButtons']//input[1]");
		newLease.done().click();
		
		//UtilityMethods.waitForElementToBeClickable(driver, "//select[@id='leaseFormSelect']");
		//newLease.status(driver);
		newLease.startCalendar();
		newLease.endDate();
		newLease.publicAssistance();
		newLease.addContactButton().click();
		newLease.createNewContactButton().click();
		String fname=xlReader.readExcel(driver,filepath,"Leases",1,0);
		newLease.firstname().sendKeys(fname);
		String lname=xlReader.readExcel(driver,filepath,"Leases",1,1);
		newLease.lastname().sendKeys(lname);
		String email=xlReader.readExcel(driver,filepath,"Leases",1,2);
		newLease.email().sendKeys(email);
		newLease.saveNewContact().click();
		UtilityMethods.scrollDown(driver);
		newLease.saveLease().click();
		UtilityMethods.waitForElementToLoad(driver, "//form[1]/div[10]/div[3]/input[2]");
		newLease.cancel().click();
	}

}
