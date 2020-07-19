package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.TestBase;

public class RentBump extends TestBase {

	public static WebElement rentBump(){
		return driver.findElement(By.xpath("//a[contains(text(),'Rent Bump')]"));
	}
	public static WebElement rentBumpType(){
		/*WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement radio = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='chargeAmount']")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", radio);*/
		
		return driver.findElement(By.id("chargeAmount"));
	}
	public static WebElement rentBumpAmount(){
		return driver.findElement(By.id("rentalBumpAmountAsString"));
	}
	public static WebElement percentage(){
		return driver.findElement(By.id("chargePercent"));
	}
	public static WebElement rentBumpPercentage(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id("rentalBumpPercentAsString")));
		return driver.findElement(By.id("rentalBumpPercentAsString"));
	}
	public static WebElement save(){
		return driver.findElement(By.id("sendButton"));
	}
	public static WebElement done(){
		return driver.findElement(By.xpath("//input[@value='Done']"));
	}
	
}
