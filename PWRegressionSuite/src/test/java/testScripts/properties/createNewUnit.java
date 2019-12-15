package testScripts.properties;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import dataReader.Excel_Reader;
import pageObjects.properties.newUnit;
import testBase.TestBase;
import utilities.Take_Screenshot;
import utilities.explicitWait;

//@Listeners(utilities.Listeners.class)
public class createNewUnit extends TestBase  {	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	Excel_Reader xlReader = new Excel_Reader();
		
	@Test
	public void createUnit() throws IOException {
		initialization();
		driver.findElement(By.xpath("//a[contains(text(),'Properties')]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td[2]/div[1]/form/div[10]/div[1]/div/table/tbody/tr/td[3]/table/tbody/tr[2]/td/h2/a")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td[2]/div[1]/form/div[10]/table/tbody/tr[1]/td[2]/span/a")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New Unit')]")).click();
		String filepath = System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\PWData.xlsx";
		String sheetname = "Properties";
		String unit = xlReader.readExcel(driver, filepath, "Properties", 1, 0);
		String desc = xlReader.readExcel(driver, filepath, "Properties", 1, 1);
		newUnit.unitName(driver).sendKeys(unit);
		newUnit.description(driver).sendKeys(desc);
		newUnit.state(driver);
		newUnit.save(driver).click();
		driver.findElement(By.id("saveAddrBrokerBtnPP")).click();
	}
	@Test
	public void clickProperties() throws IOException {
		initialization();
		/*WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Leases')]")));*/
		explicitWait.waitForElementToLoad(driver, "//a[contains(text(),'Properties')]");
		driver.findElement(By.xpath("//a[contains(text(),'Properties')]aaa")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'FEATURED_2bd')]")).click();
	}
	@Test
	public void openDashboards() throws IOException{
		initialization();
		explicitWait.waitForElementToLoad(driver, "//a[contains(text(),'Dashboards')]");
		driver.findElement(By.xpath("//a[contains(text(),'Dashboards')]dd")).click();
		
	}
	// Need to capture exact failed step and handle screen capture while parallel execution and improve execution speed
	
	//@BeforeSuite
	@BeforeTest
	public void startReport(){
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Regression Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name" , "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User","Krishna");
	}
	@AfterMethod
	public void getResult(ITestResult result) throws IOException, NullPointerException {
		
		test=extent.createTest(result.getName());
		if(result.getStatus() == ITestResult.FAILURE){
			
			 test.log(Status.FAIL, "Test Case Failed is: "+result.getName());
			 test.log(Status.FAIL, "Test Case Failed is: "+result.getThrowable());
			 String screenshotPath = TestBase.takeScreenshot(driver, result.getName());
			 test.addScreenCaptureFromPath(screenshotPath);
			 //String screenshotPath = Take_Screenshot.takeScreenshot(driver, result.getName());
			 }
			else if(result.getStatus() == ITestResult.SKIP){
				test.log(Status.SKIP, "Test Case Skipped is: "+result.getName());
			 }
			 else if(result.getStatus() == ITestResult.SUCCESS){
				 test.log(Status.PASS, "Test Case passed is: "+result.getName());
			 }
		
		//driver.close();
			 
	}
	@AfterTest
	 public void endReport(){
		extent.flush();
    }
}

