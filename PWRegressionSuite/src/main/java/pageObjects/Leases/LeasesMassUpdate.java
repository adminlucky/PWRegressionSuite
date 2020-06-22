package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testBase.TestBase;


public class LeasesMassUpdate extends TestBase {
	
	public static WebElement gridEdit(){
		return driver.findElement(By.xpath("//a[contains(text(),'Grid Edit')]"));
	}
	public static WebElement massUpdate(){
		return driver.findElement(By.xpath("//span[contains(text(),'Mass Update')]"));
	}
	public static void column(){
		(new Select(driver.findElement(By.xpath("//select[@id='massUpdateColumnIndex']")))).selectByIndex(1);
	}
	public static WebElement newValue(){
		return driver.findElement(By.xpath("//input[@id='massUpdateValue']"));
	}
	public static WebElement submit(){
		return driver.findElement(By.xpath("//input[@id='submitMassUpdateButtonee']"));
	}
}
