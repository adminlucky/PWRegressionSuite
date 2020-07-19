package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;
import utilities.UtilityMethods;

public class MoveoutAndTerminateLease extends TestBase {
	
	public static WebElement element = null;  
	
	public static WebElement firstActiveLease(){
		return driver.findElement(By.xpath("//td[@id='cell_0_0']//self::a"));
	}
	public static WebElement moveOutLink(){
		return driver.findElement(By.xpath("//a[contains(text(),'Move Out & Terminate')]"));
	}
	public static void reason(){
		driver.findElement(By.xpath("//td[2]//a[1]//img[1]")).click();
		(new Select(driver.findElement(By.name("entity.reasonForLeaving")))).selectByVisibleText("MOVE CITY");
	}
	public static void startCalendar(){
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='entity.moveOutDateAsString']")));
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		driver.findElement(By.xpath("//input[@name='entity.moveOutDateAsString']")).sendKeys(date);
	}
	public static WebElement disablePortal(){
		return driver.findElement(By.id("disablePortalAccess"));
	}
	public static WebElement comment(){
		UtilityMethods.scrollDown(driver);
		return driver.findElement(By.name("transferComments"));
	}
	public static WebElement save(){
		return driver.findElement(By.xpath("(//input[@value='Save'])[2]"));
	}

}
