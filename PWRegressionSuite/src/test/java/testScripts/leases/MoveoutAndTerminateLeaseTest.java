package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.Leases.MoveoutAndTerminateLease;
import testBase.TestBase;


public class MoveoutAndTerminateLeaseTest extends TestBase {

	@Test
	public void moveoutAndTerminate() throws IOException{
		initialization();
		//UtilityMethods.waitForElementToLoad(driver, "//a[contains(text(),'Leases')]");
		driver.findElement(By.xpath("//a[contains(text(),'Leases')]")).click();
		driver.findElement(By.xpath("//a[@href=\"javascript:showActive('Active');\"]")).click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		MoveoutAndTerminateLease.moveOutLink().click();
		MoveoutAndTerminateLease.startCalendar();
		MoveoutAndTerminateLease.reason();
		MoveoutAndTerminateLease.disablePortal().click();
		MoveoutAndTerminateLease.comment().sendKeys("Terminating lease");
		MoveoutAndTerminateLease.save().click();
	}
}
