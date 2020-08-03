package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.UtilityMethods;


public class NewLeaseWithExistingContact extends TestBase {
	
	//public static WebElement element = null;
	//public static WebElement vacantUnit;
	
	
	public static WebElement searchText(){
		return driver.findElement(By.xpath("//input[@id='searchText']"));
	}
	public static WebElement searchButton(){
		return driver.findElement(By.xpath("//div[@id='lookupField']//input[2]"));
	}
	public static WebElement selectContact(){
		return driver.findElement(By.xpath("//div[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]"));
	}
	public static void saveContact(){
		driver.findElement(By.xpath("//div[@id='primaryButtons']//input[1]")).click();
		//To handle prospect contact
		if(driver.findElements(By.xpath("//div[@id='editProspectStatus']")).size() > 0){
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Buttons']//input[1]")));
			driver.findElement(By.xpath("//div[@class='Buttons']//input[1]")).click();
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='editProspectStatus']")));
		}
		else{
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='addContactForm']")));
			//UtilityMethods.waitForElementToBeInvisible(driver, "//div[@id='addContactForm']");
		}
	}
	
}
