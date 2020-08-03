package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.UtilityMethods;

public class TotalLinks extends TestBase {
	
	public static void draftLeases(){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"javascript:showDraft();\"]")));
		driver.findElement(By.xpath("//a[@href=\"javascript:showDraft();\"]")).click();
		((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	}
	public static void evictionLeases(){
		driver.findElement(By.xpath("//a[@href=\"javascript:showEviction( 'Eviction' );\"]")).click();
		((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	}
	public static void terminatedLeases(){
		driver.findElement(By.xpath("//a[@href=\"javascript:showTerminated( 'Terminated' );\"]")).click();
		((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	}
	public static void noticeGivenLeases(){
		driver.findElement(By.xpath("//a[@href=\"javascript:showNoticeGiven('Active - Notice Given');\"]")).click();
		((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	}
	
		
		
}
