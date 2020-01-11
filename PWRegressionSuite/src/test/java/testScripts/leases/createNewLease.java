package testScripts.leases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dataReader.Excel_Reader;
import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.PageScroll;
import utilities.explicitWait;

public class createNewLease extends TestBase {
	
	Excel_Reader xlReader = new Excel_Reader();
	
	@Test
	public void createLease() throws IOException, InterruptedException{
		test=extent.createTest("createLease");
		initialization();
		String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
		explicitWait.waitForElementToLoad(driver, "//a[contains(text(),'Leases')]");
		driver.findElement(By.xpath("//a[contains(text(),'Leases')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New Lease')]")).click();
		newLease.location(driver).click();
		newLease.nextPage(driver).click();
		newLease.selectLocation(driver).click();
		newLease.done(driver).click();
		newLease.status(driver);
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		newLease.startCalendar(driver).sendKeys(date);
		//newLease.startDate(driver).click();
		newLease.endDate(driver);
		newLease.publicAssistance(driver);
		newLease.addContactButton(driver).click();
		newLease.createNewContactButton(driver).click();
		String fname=xlReader.readExcel(driver,filepath,"Leases",1,0);
		newLease.firstname(driver).sendKeys(fname);
		String lname=xlReader.readExcel(driver,filepath,"Leases",1,1);
		newLease.lastname(driver).sendKeys(lname);
		String email=xlReader.readExcel(driver,filepath,"Leases",1,2);
		newLease.email(driver).sendKeys(email);
		newLease.saveNewContact(driver).click();
		//explicitWait.waitForElementToLoad(driver, "//div[7]//input[1]");
		//PageScroll.scrollDown(driver);
		newLease.saveLease(driver).click();
		//explicitWait.waitForElementToLoad(driver, "//form[1]/div[10]/div[3]/input[2]");
		//newLease.cancel(driver).click();
	}

}
