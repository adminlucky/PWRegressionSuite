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
import utilities.UtilityMethods;

	
	public class newLeaseWithLeaseForm extends TestBase {
		
		public static WebElement element = null;
		public static WebElement vacantUnit;
		
		public static void leaseForm(){
			(new Select(driver.findElement(By.xpath("//select[@id='leaseEditForm.entity.formID']")))).selectByIndex(1);
		}
		public static WebElement location(){
			//return driver.findElement(By.xpath("(//table[@id='layoutTable']//table[1]//tbody[1]//tr[2]//td[1]//input[1])[1]"));
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Attach Location']")));
			return driver.findElement(By.xpath("//input[@value='Attach Location']"));
		}
		/*public static WebElement selectLocation(){
			String vacantUnitXpath = null;
			
			for(int i=1; i<11; i++)
			{
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
		}*/
		
		
		public static WebElement done(){
			return driver.findElement(By.xpath("//div[@id='attachUnitForm']//div[@class='primaryButtons']//input[1]"));
		}
		
		public static void startCalendar(){
			//WebDriverWait wait = new WebDriverWait(driver, 10);
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='entity.startDateAsString']")));
			String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
			driver.findElement(By.xpath("//input[@name='entity.startDateAsString']")).sendKeys(date);
		}
		public static void endDate(){
			//UtilityMethods.waitForElementToBeInvisible(driver, "//div[@id='attachUnitForm']");
			//(new Select(driver.findElement(By.xpath("//select[@id='leaseFormSelect']")))).selectByValue("5");
			(new Select(driver.findElement(By.xpath("//select[@id='leaseFormSelect']")))).selectByIndex(5);
		}
		/*public static WebElement searchText(){
			return driver.findElement(By.xpath("//input[@id='searchText']"));
		}
		public static WebElement searchButton(){
			return driver.findElement(By.xpath("//div[@id='lookupField']//input[2]"));
		}*/
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
		public static void scheduleInspection(){
			(new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='contentDiv']//div[1]//input[1]")));
			driver.findElement(By.xpath("//input[@id='useInspection']")).click();
		}
		public static void inspectionStartDate(){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='leaseInspectionStartDateAsString']")));
			String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
			driver.findElement(By.xpath("//input[@name='leaseInspectionStartDateAsString']")).sendKeys(date);
		}
		public static void managedBy(){
			driver.findElement(By.xpath("//td[2]//a[1]//img[1]")).click();
			UtilityMethods.waitForElementToBeInvisible(driver, "//div[4]/table[1]/tbody[1]/tr[2]/td[3]");
			
			(new Select(driver.findElement(By.name("entity.leaseInspectionRecurrence.managedByID")))).selectByIndex(1);
		}
		public static WebElement costEstimate(){
			return driver.findElement(By.name("leaseInspectionCostEstimateAsString"));
		}
		public static void saveLease(){
			driver.findElement(By.xpath("(//input[@value='Save'])[2]")).click();
			UtilityMethods.waitForElementToLoad(driver, "//form[1]/div[10]/div[3]/input[2]");
		}
		public static void cancel(){
			driver.findElement(By.xpath("//form[1]/div[10]/div[3]/input[2]")).click();
			UtilityMethods.waitForElementToBeInvisible(driver, "//div[@id='moveInForm']");
		}

}
