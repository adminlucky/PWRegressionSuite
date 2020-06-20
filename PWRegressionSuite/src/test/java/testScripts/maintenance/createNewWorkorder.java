package testScripts.maintenance;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Maintenance.newWorkorder;
import testBase.TestBase;
import utilities.UtilityMethods;

public class createNewWorkorder extends TestBase {
	
	@Test
	public void createWorkorder() throws IOException {
		test=extent.createTest("createWorkorder");
		initialization();
		driver.findElement(By.xpath("//a[contains(text(),'Maintenance')]")).click();
		driver.findElement(By.xpath("//input[@class='button']")).click();
		newWorkorder.attachLocation(driver).click();
		newWorkorder.searchLocation(driver).sendKeys("*");
		newWorkorder.searchButton(driver).click();
		newWorkorder.selectLocation(driver).click();
		newWorkorder.done(driver).click();
		UtilityMethods.clickByXpath(driver, "//select[@name='entity.source']");
		newWorkorder.source(driver);
		//UtilityMethods.waitForElementToBeClickable(driver, "//input[@name='entity.publishToTenantPortal']");
		//UtilityMethods.clickByXpath(driver, "//input[@name='entity.publishToTenantPortal']");
		newWorkorder.uncheckTenantPortal(driver).click();
		//UtilityMethods.waitForElementToBeClickable(driver, "//input[@id='ownerPortalPublishCheckbox']");
		//UtilityMethods.clickByXpath(driver, "//input[@id='ownerPortalPublishCheckbox']");
		newWorkorder.uncheckOwnerPortal(driver).click();
		//newWorkorder.saveWO(driver).click();
		Assert.assertTrue(driver.getPageSource().contains("Back To Work Orders Home"), "-----Work Order creation failed------");
	}
}
