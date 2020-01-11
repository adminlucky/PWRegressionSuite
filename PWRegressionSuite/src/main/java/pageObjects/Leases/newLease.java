package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.explicitWait;

public class newLease extends TestBase {
	
	public static WebElement element = null;
	
	public static WebElement location(WebDriver driver){
		return driver.findElement(By.xpath("//table[@id='layoutTable']//table[1]//tbody[1]//tr[1]//td[1]//input[1]"));
	}
	public static WebElement selectLocation(WebDriver driver){
		return driver.findElement(By.xpath("//form[1]/div[9]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[1]/input[1]"));
		//Need to handle the element (vacant unit) effectively
	}
	public static WebElement nextPage(WebDriver driver){
		return driver.findElement(By.xpath("//a[@class='pageNext']"));
	}
	public static WebElement done(WebDriver driver){
		return driver.findElement(By.xpath("//div[@id='attachUnitForm']//div[@class='primaryButtons']//input[1]"));
	}
	public static void status(WebDriver driver){
		new Select(driver.findElement(By.xpath("//select[@id='entity.status']"))).selectByValue("Active");;
	}
	public static WebElement startCalendar(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='entity.startDateAsString']")));
		//return driver.findElement(By.xpath("//input[@name='entity.startDateAsString']"));
	}
	public static WebElement startDate(WebDriver driver){
		return driver.findElement(By.xpath("//a[@id=' pk121719']"));
	}
	public static void endDate(WebDriver driver){
		(new Select(driver.findElement(By.xpath("//select[@id='leaseFormSelect']")))).selectByVisibleText("1 year");
	}
	public static void publicAssistance(WebDriver driver){
		(new Select(driver.findElement(By.xpath("//select[@name='entity.publicAssistanceProgram']")))).selectByVisibleText("Section 8");
	}
	public static WebElement addContactButton(WebDriver driver){
		/*element = driver.findElement(By.xpath("//div[@id='contentDiv']//div[1]//input[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();*/
		element = driver.findElement(By.xpath("//div[@id='contentDiv']//div[1]//input[1]"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", element);
		return element;
	}
	/*public static WebElement searchText(WebDriver driver){
		return driver.findElement(By.xpath("//input[@id='searchText']"));
	}
	public static WebElement searchButton(WebDriver driver){
		return driver.findElement(By.xpath("//div[@id='lookupField']//input[2]"));
	}*/
	public static WebElement createNewContactButton(WebDriver driver){
		return driver.findElement(By.xpath("//div[@id='primaryButtons']//input[3]"));
	}
	public static WebElement firstname(WebDriver driver){
		return driver.findElement(By.xpath("//input[@id='leaseContact.firstName']"));
	}
	public static WebElement lastname(WebDriver driver){
		return driver.findElement(By.xpath("//input[@id='leaseContact.lastName']"));
	}
	public static WebElement email(WebDriver driver){
		return driver.findElement(By.xpath("//input[@id='leaseContact.email']"));
	}
	public static WebElement saveNewContact(WebDriver driver){
		return driver.findElement(By.xpath("//div[@id='editContactForm']//div[@class='primaryButtons']//input[1]"));
	}
	public static WebElement saveLease(WebDriver driver){
		return driver.findElement(By.xpath("(//input[@value='Save'])[1]"));
	}
	public static WebElement cancel(WebDriver driver){
		return driver.findElement(By.xpath("//form[1]/div[10]/div[3]/input[2]"));
	}
}
