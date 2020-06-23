package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class GenerateCRPs extends TestBase {
		
	public static WebElement createdDateLink(){
		return driver.findElement(By.xpath("//th[@id='th_7']"));
	}
	public static WebElement sortAtoZ(){
		
		//return driver.findElement(By.xpath("//li[contains(text(),'Sort A to Z')]"));
		return driver.findElement(By.xpath("//form[1]/div[13]/div[7]/ul[1]/li[1]"));
		
	}
	public static WebElement startDate(){
		return driver.findElement(By.xpath("//form[1]/div[7]/div[1]/table[1]/tbody[1]/tr[3]/td[1]"));
	}
	public static WebElement generateCRP(){
		return driver.findElement(By.xpath("//a[contains(text(),'Generate CRPs')]"));
	}
	public static void stateMinnesota(){
		(new Select(driver.findElement(By.xpath("//select[@name='crpState']")))).selectByVisibleText("Minnesota");
	}
	public static void stateWisconsin(){
		(new Select(driver.findElement(By.xpath("//select[@name='crpState']")))).selectByVisibleText("Wisconsin");
	}
	public static void year(String year){
		(new Select(driver.findElement(By.xpath("//select[@name='yearOffset']")))).selectByValue(year);
		//return driver.findElement(By.xpath("//select[@name='yearOffset']"));
	}
	public static WebElement contact(){
		return driver.findElement(By.xpath("//div[3]/table[1]/tbody[1]/tr[4]/td[1]/input[1]"));
	}
	public static WebElement attachToLeaseDocs(){
		return driver.findElement(By.xpath("//input[@value='Attach to Lease Documents']"));
	}
	public static WebElement done(){
		return driver.findElement(By.xpath("//input[@value='Done']"));
	}
	
}
