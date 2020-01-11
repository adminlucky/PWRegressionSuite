package testScripts.maintenance;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Maintenance.newWorkorder;
import testBase.TestBase;
import utilities.ClickElement;
import utilities.explicitWait;

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
		ClickElement.clickByXpath(driver, "//select[@name='entity.source']");
		newWorkorder.source(driver);
		ClickElement.clickByXpath(driver, "//input[@name='entity.publishToTenantPortal']");
		newWorkorder.uncheckTenantPortal(driver).click();
		ClickElement.clickByXpath(driver, "//input[@id='ownerPortalPublishCheckbox']");
		newWorkorder.uncheckOwnerPortal(driver).click();
		newWorkorder.saveWO(driver).click();
		Assert.assertTrue(driver.getPageSource().contains("Back To Work Orders Home123"), "-----Work Order creation failed------");
	}
}
