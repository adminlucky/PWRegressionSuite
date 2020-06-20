package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class newLease extends TestBase {
	
	public static WebElement element = null;
	public static WebElement vacantUnit;
	
	public static WebElement location(){
		//return driver.findElement(By.xpath("//table[@id='layoutTable']//table[1]//tbody[1]//tr[2]//td[1]//input[1]"));
		return driver.findElement(By.xpath("//table[@id='layoutTable']//table[1]//tbody[1]//tr[1]//td[1]//input[1]"));
	}
	public static WebElement selectLocation(){
		String vacantUnitXpath = null;
		for(int i=1; i<11; i++)
		{
			// xpath for check box : (//input[starts-with(@id,'unit')])[1]
			String vacantText = "//body[@id='theBody']//tr//tr[" +i +"]//td[5]";
			vacantUnitXpath = "(//input[starts-with(@id,'unit')])[" +i +"]";
			String unitState = driver.findElement(By.xpath(vacantText)).getText().trim();
			if(unitState.equalsIgnoreCase("Vacant")){
				vacantUnit = driver.findElement(By.xpath(vacantUnitXpath));
				break;
			}
			else{
				continue;
				}
		}
		return vacantUnit;
	}
	
	
	public static WebElement done(){
		return driver.findElement(By.xpath("//div[@id='attachUnitForm']//div[@class='primaryButtons']//input[1]"));
	}
	/*public static void status(){
		new Select(driver.findElement(By.xpath("//select[@id='entity.status']"))).selectByValue("Active");;
	}*/
	public static void startCalendar(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='entity.startDateAsString']")));
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		driver.findElement(By.xpath("//input[@name='entity.startDateAsString']")).sendKeys(date);
	}
	/*public static WebElement startDate(){
		return driver.findElement(By.xpath("//a[@id=' pk121719']"));
	}*/
	public static void endDate(){
		(new Select(driver.findElement(By.xpath("//select[@id='leaseFormSelect']")))).selectByValue("5");
		//(new Select(driver.findElement(By.xpath("//select[@id='leaseFormSelect']")))).selectByIndex(5);
	}
	public static void publicAssistance(){
		//UtilityMethods.waitForElementToBeInvisible(driver,"//input[@name='entity.startDateAsString']");
		(new Select(driver.findElement(By.xpath("//select[@name='entity.publicAssistanceProgram']")))).selectByVisibleText("Section 8");
	}
	public static WebElement addContactButton(){
		/*element = driver.findElement(By.xpath("//div[@id='contentDiv']//div[1]//input[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();*/
		element = driver.findElement(By.xpath("//div[@id='contentDiv']//div[1]//input[1]"));
		//element = driver.findElement(By.xpath("(//div[@id='contentDiv']//div[1]//input[1])[1]"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", element);
		return element;
	}
	public static WebElement createNewContactButton(){
		return driver.findElement(By.xpath("//div[@id='primaryButtons']//input[3]"));
	}
	public static WebElement firstname(){
		return driver.findElement(By.xpath("//input[@id='leaseContact.firstName']"));
	}
	public static WebElement lastname(){
		return driver.findElement(By.xpath("//input[@id='leaseContact.lastName']"));
	}
	public static WebElement email(){
		return driver.findElement(By.xpath("//input[@id='leaseContact.email']"));
	}
	public static WebElement saveNewContact(){
		return driver.findElement(By.xpath("//div[@id='editContactForm']//div[@class='primaryButtons']//input[1]"));
	}
	public static WebElement saveLease(){
		return driver.findElement(By.xpath("(//input[@value='Save'])[2]"));
	}
	public static WebElement cancel(){
		return driver.findElement(By.xpath("//form[1]/div[10]/div[3]/input[2]"));
	}
}
