package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.adjustments;
import testBase.TestBase;

public class adjustmentsTest extends TestBase {
	
	@Test
	public void createAdjustment() throws IOException{
		//test=extent.createTest("createAdjustment");
		initialization();
		driver.findElement(By.xpath("//a[contains(text(),'Leases')]")).click();
		driver.findElement(By.xpath("//a[@href=\"javascript:showActive('Active');\"]")).click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		adjustments.clickLedger().click();
		adjustments.adjustmentsButton().click();
		adjustments.adjustment().click();
		adjustments.ref().sendKeys("6734");
		adjustments.amount().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		adjustments.amount().sendKeys("21");
		adjustments.comment().sendKeys("Adjustment for testing purpose");
		adjustments.save().click();
	}
	@Test
	public void createDiscount() throws IOException{
		initialization();
		driver.findElement(By.xpath("//a[contains(text(),'Leases')]")).click();
		driver.findElement(By.xpath("//a[@href=\"javascript:showActive('Active');\"]")).click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		adjustments.clickLedger().click();
		adjustments.adjustmentsButton().click();
		adjustments.discount().click();
		adjustments.account();
		adjustments.ref().sendKeys("3217");
		adjustments.amount().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		adjustments.amount().sendKeys("-4");
		adjustments.comment().sendKeys("Discount for testing purpose");
		adjustments.save().click();
	}
	@Test
	public void createRefund() throws IOException{
		//test=extent.createTest("createRefund");
		initialization();
		driver.findElement(By.xpath("//a[contains(text(),'Leases')]")).click();
		driver.findElement(By.xpath("//a[@href=\"javascript:showActive('Active');\"]")).click();
		MoveoutAndTerminateLease.firstActiveLease().click();
		adjustments.clickLedger().click();
		adjustments.adjustmentsButton().click();
		adjustments.refund().click();
		adjustments.payFrom();
		adjustments.amount().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		adjustments.amount().sendKeys("-5");
		adjustments.comment().sendKeys("Refund for testing purpose");
		adjustments.save().click();
	}
}
