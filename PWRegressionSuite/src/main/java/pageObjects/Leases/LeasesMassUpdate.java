package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.UtilityMethods;


public class LeasesMassUpdate extends TestBase {
	
	public static WebElement gridEdit(){
		return driver.findElement(By.xpath("//a[contains(text(),'Grid Edit')]"));
	}
	public static WebElement massUpdate(){
		return driver.findElement(By.xpath("//span[contains(text(),'Mass Update')]"));
	}
	public static void column(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id='massUpdateDiv']"))));
		(new Select(driver.findElement(By.xpath("//select[@id='massUpdateColumnIndex']")))).selectByIndex(1);
	}
	public static WebElement newValue(){
		return driver.findElement(By.xpath("//input[@id='massUpdateValue']"));
	}
	public static void submit(){
		driver.findElement(By.xpath("//input[@id='submitMassUpdateButton']")).click();
		//UtilityMethods.waitForElementToBeInvisible(driver, "//*[@id='massUpdateDiv']");
	}
	public static void ok(){
		driver.switchTo().alert().accept();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[2]/div[2]/ul[1]/li[5]/a[1]")));
	}
}
