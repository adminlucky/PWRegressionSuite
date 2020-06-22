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
	
}
