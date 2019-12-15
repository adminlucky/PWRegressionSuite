package testScripts.properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.TestBase;

public class appendResults extends TestBase {
	WebDriver driver;
	@Test
	public void OtherClassTest(){
		Assert.assertTrue(true);
	}
	@Test
	public void OtherClassFailedTest(){
		System.setProperty("webdriver.gecko.driver","C:\\Personal\\Softwares\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("www.google.co/");
		Assert.assertTrue(false);
	}
}
