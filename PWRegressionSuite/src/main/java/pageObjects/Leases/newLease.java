package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import utilities.UtilityMethods;

public class newLease extends TestBase {
	
	public static WebElement element = null;
	public static WebElement vacantUnit;
	
	public static WebElement leases(){
		//UtilityMethods.waitForElementToBeClickable(driver, "//div[3]/div[2]/div[2]/ul[1]/li[5]/a[1]");
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[2]/div[2]/ul[1]/li[5]/a[1]")));
		return driver.findElement(By.xpath("//div[3]/div[2]/div[2]/ul[1]/li[5]/a[1]"));
	}
	public static WebElement activeLeases(){
		return driver.findElement(By.xpath("//a[@href=\"javascript:showActive('Active');\"]"));
	}
	public static WebElement draftLeases(){
		return driver.findElement(By.xpath("//a[@href=\"javascript:showDraft();\"]"));
	}
	public static WebElement newLeaseLink(){
		return driver.findElement(By.xpath("//a[contains(text(),'New Lease')]"));
	}
	public static WebElement location(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Attach Location']")));
		return driver.findElement(By.xpath("//input[@value='Attach Location']"));
	}
	public static WebElement selectLocation(){
		String vacantUnitXpath = null;
		for(int i=1; i<10; i++) 
		{
			for(int j=1; j<11; j++)
			{
				// xpath for check box : (//input[starts-with(@id,'unit')])[1]
				String vacantText = "//body[@id='theBody']//tr//tr[" +j +"]//td[5]";
				vacantUnitXpath = "(//input[starts-with(@id,'unit')])[" +j +"]";
				String unitState = driver.findElement(By.xpath(vacantText)).getText().trim();
				if(unitState.equalsIgnoreCase("Vacant")){
					vacantUnit = driver.findElement(By.xpath(vacantUnitXpath));
					break;
				}
				else	{	continue;}
				
			}
			if(vacantUnit != null) {	break;}
			else {	driver.findElement(By.xpath("//a[@class='pageNext']")).click();}
		}
		return vacantUnit;
	}
	
	
	public static void done(){
		UtilityMethods.waitForElementToBeClickable(driver, "//div[@id='attachUnitForm']//div[@class='primaryButtons']//input[1]");
		driver.findElement(By.xpath("//div[@id='attachUnitForm']//div[@class='primaryButtons']//input[1]")).click();
		UtilityMethods.waitForElementToBeInvisible(driver, "//div[@id='attachUnitForm']");
	}
	/*public static void status(){
		new Select(driver.findElement(By.xpath("//select[@id='entity.status']"))).selectByValue("Draft");;
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
		//(new Select(driver.findElement(By.xpath("//select[@id='leaseFormSelect']")))).selectByValue("5");
		(new Select(driver.findElement(By.xpath("//select[@id='leaseFormSelect']")))).selectByIndex(5);
	}
	public static void publicAssistance(){
		driver.findElement(By.xpath("//td[2]//a[1]//img[1]")).click();
		//UtilityMethods.waitForElementToBeClickable(driver, "//div[4]/table[1]/tbody[1]");
		UtilityMethods.waitForElementToBeInvisible(driver, "//div[4]/table[1]/tbody[1]");
		(new Select(driver.findElement(By.xpath("//select[@name='entity.publicAssistanceProgram']")))).selectByVisibleText("Section 8");
	}
	//Clicked twice before throwing exception
	public static void addContactButton(){
		/*int attempts = 0;
	    while(attempts < 2) {
	        try {
	        	driver.findElement(By.xpath("//div[@id='contentDiv']//div[1]//input[1]")).click();
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }*/
	    //(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='contentDiv']//div[1]//input[1]")));
	    (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='contentDiv']//div[1]//input[1]")));
	    driver.findElement(By.xpath("//div[@id='contentDiv']//div[1]//input[1]")).click();
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
	public static void saveNewContact(){
		driver.findElement(By.xpath("//div[@id='editContactForm']//div[@class='primaryButtons']//input[1]")).click();
		UtilityMethods.waitForElementToBeInvisible(driver, "//div[@id='editContactForm']");
	}
	public static void unScheduleInspection(){
		driver.findElement(By.xpath("//div[@id='leaseInspectionTable']//input[2]")).click();
		//UtilityMethods.waitForElementToBeInvisible(driver, "//div[@id='leaseInspectionTable']//tbody");
	}
	public static void saveLease(){
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[2]")));
		driver.findElement(By.xpath("(//input[@value='Save'])[2]")).click();
		//UtilityMethods.waitForElementToLoad(driver, "//form[1]/div[10]/div[3]/input[2]");
	}
	public static void cancel(){
		//UtilityMethods.scrollDownHalf(driver);
		//(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@value='Cancel']"))));
		//driver.findElement(By.xpath("//*[@id='moveInForm']/div[3]/input[2]")).click();
		//driver.findElement(By.xpath("//div[@id='moveInForm']//div[@class='primaryButtons']//input[1]")).click();
		driver.findElement(By.xpath("//div[3]/div[2]/table/tbody/tr/td[2]/form/div[10]/div[3]/input[2]")).click();
		UtilityMethods.waitForElementToBeInvisible(driver, "//div[@id='moveInForm']");
	}
	
	
	
}
