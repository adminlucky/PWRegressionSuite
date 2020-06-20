package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.Leases.LeasesMassUpdate;
import testBase.TestBase;

public class massUpdateTest extends TestBase {
	@Test
	public void leasesMassUpdate() throws IOException{
		initialization();
		driver.findElement(By.xpath("//a[contains(text(),'Leases')]")).click();
		LeasesMassUpdate.gridEdit().click();
		LeasesMassUpdate.massUpdate().click();
		LeasesMassUpdate.column();
		LeasesMassUpdate.newValue().sendKeys("Section 8");
		LeasesMassUpdate.submit().click();
		driver.switchTo().alert().accept();
		
	}
}
