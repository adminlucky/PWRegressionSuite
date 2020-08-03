package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.UtilityMethods;


public class GlobalSearch extends TestBase {
	
	public static WebElement globalSearch(){
		return driver.findElement(By.id("searchText"));
	}
	
	public static void clickOnExactLease(){
		driver.findElement(By.xpath("//div[3]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/form[1]/div[1]/ul[1]/li[2]")).click();
		AddAutoCharge.waitForLeases();
	}
	public static WebElement searchTag(){
		return driver.findElement(By.xpath("//span[contains(text(),'Search Tag')]"));
	}
	public static WebElement searchTagText(){
		return driver.findElement(By.id("searchTagTxt"));
	}
	public static WebElement saveSearchTag(){
		return driver.findElement(By.id("searchTagSaveButton"));
	}
	
}
