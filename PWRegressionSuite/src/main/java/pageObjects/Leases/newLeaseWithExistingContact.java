package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.TestBase;


public class newLeaseWithExistingContact extends TestBase {
	
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
	public static WebElement saveContact(){
		return driver.findElement(By.xpath("//div[@id='primaryButtons']//input[1]"));
	}
	
}
