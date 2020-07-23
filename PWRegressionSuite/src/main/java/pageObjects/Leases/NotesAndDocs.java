package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.UtilityMethods;

public class NotesAndDocs extends TestBase {
	
	public static WebElement notesAndDocsTab(){
		return driver.findElement(By.xpath("//span[@id='ndHeader']"));
	}
	public static WebElement attachNote(){
		return driver.findElement(By.xpath("//div[@id='subtab7']//div[2]//input[1]"));
	}
	public static WebElement subject(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='note.subject']")));
		return driver.findElement(By.xpath("//input[@id='note.subject']"));
	}
	public static WebElement privateNote(){
		return driver.findElement(By.name("note.private"));
	}
	public static void noteDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Calendar c = Calendar.getInstance();
	    c.setTime(new Date()); // Use today date
	    c.add(Calendar.DATE, 3); // Adding 3 days
	    String date = sdf.format(c.getTime());
	      
	    /*JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("document.getElementByID('note.dateAsString').value='"+date+"'");*/
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.name("note.dateAsString")));
		//String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		driver.findElement(By.name("note.dateAsString")).sendKeys(date);
		
	}
	
	public static WebElement body(){
		return driver.findElement(By.name("note.body"));
	}
	public static WebElement saveNote(){
		return driver.findElement(By.xpath("//div[@id='editNoteForm']//div[@class='primaryButtons']//input[1]"));
	}
	
	
	
	
	
	
}
