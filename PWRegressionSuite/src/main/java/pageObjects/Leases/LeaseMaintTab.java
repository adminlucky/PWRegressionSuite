package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testBase.TestBase;

public class LeaseMaintTab extends TestBase {
	
	public static WebElement maintTab(){
		//return driver.findElement(By.xpath("//tr[1]/td[2]/form[1]/div[8]/a[6]"));
		return driver.findElement(By.xpath("//a[@href='#subtab5']"));
	}
	public static WebElement newWOButton(){
		return driver.findElement(By.id("newWOButton1"));
	}
	
}
