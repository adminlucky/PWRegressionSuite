package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.UtilityMethods;

public class EditLease extends TestBase {
	
	public static WebElement firstLease(){
		return driver.findElement(By.xpath("//td[@id='cell_0_0']//self::a"));
	}
	
	public static void edit(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='primaryButtons']//input[2]")));
		driver.findElement(By.xpath("//div[@class='primaryButtons']//input[2]")).click();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id("entity.status")));
	}
	
	public static void activeToEviction(){
		(new Select(driver.findElement(By.id("entity.status")))).selectByVisibleText("Eviction");
	}
	public static void activeToTerminate(){
		(new Select(driver.findElement(By.id("entity.status")))).selectByVisibleText("Terminated");
	}
	public static void draftToActive(){
		(new Select(driver.findElement(By.id("entity.status")))).selectByVisibleText("Active");
	}
		
	public static void publicAssistance(){
		(new Select(driver.findElement(By.name("entity.publicAssistanceProgram")))).selectByVisibleText("Rent Control");
	}
	public static WebElement description(){
		return driver.findElement(By.xpath("//textarea[@name='entity.comments']"));
	}
	public static void saveLease(){
		driver.findElement(By.xpath("(//input[@onclick='save()'])[1]")).click();
		UtilityMethods.waitForElementToBeInvisible(driver, "//form[@id='leaseEditForm']");
	}
	public static void saveEviction(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='primaryButtons']//following::input)[1]")));
		driver.findElement(By.xpath("(//div[@class='primaryButtons']//following::input)[1]")).click();
		//UtilityMethods.waitForElementToBeInvisible(driver, "//form[@id='leaseEditForm']");
	}
	public static void saveTerminate(){
		driver.findElement(By.xpath("(//input[@onclick='save()'])[1]")).click();
		confirmTerminate();
		UtilityMethods.waitForElementToBeInvisible(driver, "//form[@id='leaseEditForm']");
	}
	public static void restrictionsSave(){
		driver.findElement(By.xpath("//*[@id='evictionRestrictionsForm']/div/input[1]")).click();;
		UtilityMethods.waitForElementToBeInvisible(driver, "//*[@id='evictionRestrictionsForm']");
	}
	
	public static void vacatedDate(){
	    (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.name("entity.moveOutDateAsString")));
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		driver.findElement(By.name("entity.moveOutDateAsString")).sendKeys(date);
	}
	public static void confirmTerminate(){
		driver.switchTo().alert().accept();
	}
	public static WebElement scheduleInspection(){
		return driver.findElement(By.xpath("//div[@id='leaseInspectionTable']//thead//input[1]"));
	}
	
	//Date not changing when date is already there  
	public static void inspectionStartDate(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.name("leaseInspectionStartDateAsString")));
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		driver.findElement(By.name("leaseInspectionStartDateAsString")).sendKeys(date);
	}
	public static WebElement costEstimate(){
		return driver.findElement(By.name("leaseInspectionCostEstimateAsString"));
	}
	public static WebElement inspectionDesc(){
		return driver.findElement(By.name("entity.leaseInspectionRecurrence.description"));
	}
	public static WebElement removeLocation(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='delete']")));
		return driver.findElement(By.xpath("//a[@class='delete']"));
	}
	
	
	
	
}
