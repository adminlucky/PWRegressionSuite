package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class RentersInsurance extends TestBase {
	
	public static WebElement rentersInsuranceTab(){
		return driver.findElement(By.xpath("//tr[1]/td[2]/form[1]/div[8]/a[7]/span[1]"));
	}
	public static WebElement recordPolicy(){
		return driver.findElement(By.xpath("//input[@value='Record Policy']"));
	}
	public static WebElement policyNumber(){
		return driver.findElement(By.xpath("//input[@id='policy.policyNumber']"));
	}
	public static void policyProvider(){
		(new Select(driver.findElement(By.xpath("//select[@name='policy.policyProvider']")))).selectByIndex(4);
	}
	
}
