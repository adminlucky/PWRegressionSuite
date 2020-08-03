package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import dataReader.Excel_Reader;
import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.GlobalSearch;
import pageObjects.Leases.Login;
import testBase.TestBase;


public class GlobalSearchTest extends TestBase {
	Excel_Reader xlReader = new Excel_Reader();
	@Test
	public void globalSearchTest() throws IOException, InterruptedException{
	test=extent.createTest("GlobalSearchTest");
	Login.refreshPage();
	String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
	String leaseName=xlReader.readExcel(driver,filepath,"Leases",2,3);
	String lastName=xlReader.readExcel(driver,filepath,"Leases",1,1);
	AddAutoCharge.waitForLeases();
	GlobalSearch.globalSearch().sendKeys(leaseName);
	(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("searchDiv")));
	GlobalSearch.clickOnExactLease();
	GlobalSearch.globalSearch().sendKeys(lastName);
	(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("searchDiv")));
	GlobalSearch.clickOnExactLease();
	}
}
