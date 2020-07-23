package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.UtilityMethods;


public class StickyNote extends TestBase {
	
	public static WebElement setButton(){
		return driver.findElement(By.xpath("//div[@id='stickyNoteWidget']//a//img"));
	}
	public static WebElement noteBody(){
		return driver.findElement(By.xpath("//textarea[@id='stickyText']"));
	}
	public static void saveNote(){
		driver.findElement(By.xpath("//div[@id='saveStickyBtnDiv']//input[1]")).click();
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='viewStickyNoteForm']")));
	}
	public static WebElement viewButton(){
		return driver.findElement(By.xpath("//div[@id='stickyNoteWidget']//a//img"));
	}
	public static WebElement editNote(){
		return driver.findElement(By.xpath("//div[@id='editStickyBtnDiv']//input[1]"));
	}
	
}
