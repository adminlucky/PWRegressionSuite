package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import testBase.TestBase;
import utilities.UtilityMethods;

public class CreateTasks extends TestBase {
	
	public static WebElement tasksTab(){
		return driver.findElement(By.id("tasksTab"));
	}
	//Objects for single task
	public static WebElement newTask(){
		return driver.findElement(By.id("newTaskButton"));
	}
	public static WebElement taskDesc(){
		return driver.findElement(By.id("descriptionInput"));
	}
	public static void dueDate(){
		/*String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		driver.findElement(By.id("dueDateInput")).sendKeys(date);
		driver.findElement(By.id("dueDateInput")).sendKeys(Keys.chord(Keys.TAB));*/
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Calendar c = Calendar.getInstance();
	    c.setTime(new Date()); // Use today date
	    c.add(Calendar.DATE, 3); // Adding 3 days which is two weeks from the current date
	    String output = sdf.format(c.getTime());
	      
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("document.getElementById('dueDateInput').value='"+output+"'");
	}
	public static WebElement deligateInput(){
		return driver.findElement(By.id("delegateInput"));
	}
	public static WebElement deligatePerson(){
		return driver.findElement(By.xpath("//div[@id='delegateSelector']//div[1]//input[1]"));
	}
	public static WebElement saveDeligate(){
		return driver.findElement(By.xpath("//div[@id='delegateSelector']//div[@class='buttonSection']//input[1]"));
	}
	public static WebElement privateOrPublic(){
		return driver.findElement(By.name("private"));
	}
	public static WebElement saveTask(){
		return driver.findElement(By.id("newTaskSaveButton"));
	}
	
	
	//Objects for template tasks
	public static WebElement loadFromTemplate(){
		return driver.findElement(By.id("loadFromTemplateButton"));
	}
	public static void selectTemplate(){
		(new Select(driver.findElement(By.id("loadFromTemplateID")))).selectByIndex(1);
	}
	public static WebElement deligate(){
		//Called utility method 
		return UtilityMethods.waitForElementToLoad(driver, "//body[@id='theBody']//tr//tr[1]//td[3]//input[1]");
	}
	public static WebElement deligateName(){
		return driver.findElement(By.xpath("//div[@id='templateDelegateSelector']//div[1]//input[1]"));
	}
	public static WebElement saveDeligateName(){
		return driver.findElement(By.id("saveTemplateDelegateButton"));
	}
	public static WebElement createTasks(){
		return driver.findElement(By.id("createTasksButton"));
	}
	
}
