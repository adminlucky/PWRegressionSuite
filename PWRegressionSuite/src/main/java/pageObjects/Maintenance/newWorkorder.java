package pageObjects.Maintenance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class newWorkorder {
	
	public static WebElement attachLocation(WebDriver driver){
		return driver.findElement(By.xpath("//table[@class='edit']//tr[2]//td[1]//input[1]"));
	}
	public static void source(WebDriver driver){
		Select source = new Select(driver.findElement(By.xpath("//select[@name='entity.source']")));
		source.selectByVisibleText("Website");
	}
	public static WebElement searchLocation(WebDriver driver){
		return driver.findElement(By.xpath("//input[@id='searchText']"));
	}
	public static WebElement searchButton(WebDriver driver){
		return driver.findElement(By.xpath("//div[@class='lookupField']//input[2]"));
	}
	public static WebElement selectLocation(WebDriver driver){
		return driver.findElement(By.xpath("//form[1]/div[11]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]"));
	}
	public static WebElement done(WebDriver driver){
		return driver.findElement(By.xpath("//input[@id='btnDone']"));
	}
	public static WebElement uncheckTenantPortal(WebDriver driver){
		return driver.findElement(By.xpath("//input[@name='entity.publishToTenantPortal']"));
	}
	public static WebElement uncheckOwnerPortal(WebDriver driver){
		return driver.findElement(By.xpath("//input[@id='ownerPortalPublishCheckbox']"));
	}
	public static void type(WebDriver driver){
		Select type = new Select(driver.findElement(By.xpath("//select[@name='entity.type']")));
		type.selectByVisibleText("Inspection");
	}
	public static WebElement saveWO(WebDriver driver){
		return driver.findElement(By.xpath("//div[9]//input[1]"));
	}
}
