package testScripts.properties;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;
import utilities.explicitWait;

public class appendResults extends TestBase {
	
	@Test
	public void OtherClassFailedTest() throws IOException{
		test=extent.createTest("OtherClassFailedTest");
		initialization();
		//explicitWait.waitForElementToLoad(driver, "//a[contains(text(),'Properties')]");
		/*WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Leases')]")));*/
		//Assert.assertTrue(false);
		//driver.findElement(By.xpath("//a[contains(text(),'Properties')]pp")).click();
	}
	
}
