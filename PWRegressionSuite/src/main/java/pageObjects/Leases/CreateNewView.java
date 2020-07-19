package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.UtilityMethods;


public class CreateNewView extends TestBase {
	
		public static WebElement newView(){
			return driver.findElement(By.xpath("//a[contains(text(),'New View')]"));
		}
		public static WebElement viewName(){
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id("viewName")));
			return driver.findElement(By.id("viewName"));
		}
		public static void unSelectedColumn(){
			(new Select(driver.findElement(By.id("unselectedColumns")))).selectByVisibleText("Balance");
		}
		public static WebElement addColumnToView(){
			return driver.findElement(By.xpath("//td[@id='addRemoveColumns']//div[1]//a[1]//img[1]"));
		}
	
		public static void selectFilterColumn(){
			(new Select(driver.findElement(By.id("gridFilterColumn")))).selectByVisibleText("Status");
		}
		public static void selectCondition(){
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.id("gridFilterOperator")));
			(new Select(driver.findElement(By.id("gridFilterOperator")))).selectByVisibleText("equals");
		}
		public static void value(){
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("gridFilterValue1")));
			(new Select(driver.findElement(By.id("gridFilterValue1")))).selectByVisibleText("Draft");
		}
		public static WebElement addFilter(){
			return driver.findElement(By.id("filtersAddFilterButton"));
		}
		public static void saveView(){
			driver.findElement(By.id("editViewSaveButton")).click();
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='gridNewView']")));
		}
		public static void setAsDefaultView(){
			for(int i=0; i<3; i++ ){
			(new Select(driver.findElement(By.name("viewID")))).selectByIndex(i);
			
				if(driver.findElements(By.xpath("//a[@id='setAsDefaultLink']")).size() > 0){
					//(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='setAsDefaultLink']")));
					driver.findElement(By.xpath("//a[@id='setAsDefaultLink']")).click();
					//(new WebDriverWait(driver, 5)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='setAsDefaultLink']")));
					break;
					}
				continue;
				}
			
			}
		public static void selectView(){
			(new Select(driver.findElement(By.name("viewID")))).selectByIndex(2);
		}
		public static WebElement editView(){
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Edit View')]")));
			return driver.findElement(By.xpath("//a[contains(text(),'Edit View')]"));
		}
		public static void order(){
			(new Select(driver.findElement(By.id("defaultOrderByDirection")))).selectByIndex(1);
		}
}