package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.adjustments;
import pageObjects.Leases.createJE;
import testBase.TestBase;

public class createJETest extends TestBase {
	@Test
	public void createNewJE() throws IOException{
		//test=extent.createTest("createNewJE");
		initialization();
		driver.findElement(By.xpath("//a[contains(text(),'Leases')]")).click();
		driver.findElement(By.xpath("//a[@href=\"javascript:showActive('Active');\"]")).click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		adjustments.clickLedger().click();
		createJE.newJE().click();
		createJE.ref().sendKeys("je123");
		createJE.comments().sendKeys("Test Journel entry");
		createJE.debitAccount();
		createJE.debitAmount().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		createJE.debitAmount().sendKeys("125");
		createJE.creditAccount();
		createJE.creditAmount().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		createJE.creditAmount().sendKeys("125");
		createJE.saveJE().click();
	}
}
