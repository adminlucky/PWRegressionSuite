package testScripts.properties;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataReader.Excel_Reader;
import pageObjects.properties.newUnit;
import testBase.TestBase1;

public class createNewUnit extends TestBase1  {	
	
	Excel_Reader xlReader = new Excel_Reader();
		
	@Test
	public void createUnit() throws IOException {
		test=extent.createTest("createUnit");//parameter changed
		initialization();
		driver.findElement(By.xpath("//a[contains(text(),'Properties')]")).click();
		driver.findElement(By.xpath("//td[3]//table[1]//tbody[1]//tr[2]//td[1]//h2[1]//a[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'SUIT101')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New Unit')]")).click();
		String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
		String unit = xlReader.readExcel(driver, filepath, "Properties", 1, 0);
		String desc = xlReader.readExcel(driver, filepath, "Properties", 1, 1);
		newUnit.unitName(driver).sendKeys(unit);
		newUnit.description(driver).sendKeys(desc);
		newUnit.state(driver);
		newUnit.save(driver).click();
		driver.findElement(By.id("saveAddrBrokerBtn")).click();
		Assert.assertTrue(driver.getPageSource().contains(unit), "Unit creation failed");
	}
	/*@Test	
	public void clickProperties() throws IOException  {
		test=extent.createTest("clickProperties");
		initialization();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Leases')]")));
		explicitWait.waitForElementToLoad(driver, "//a[contains(text(),'Properties')]");
		driver.findElement(By.xpath("//a[contains(text(),'Properties')]")).click();
	}*/
		
	// Need to capture exact failed step and handle screen capture while parallel execution and improve execution speed
}

