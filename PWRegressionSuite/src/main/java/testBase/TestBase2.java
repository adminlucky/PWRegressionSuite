package testBase;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import dataReader.config_Reader;
import utilities.UtilityMethods;

public class TestBase2 extends config_Reader {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
			
	public static void initialization() throws IOException
	{
		readConfigFile();
		String browser = prop.getProperty("browser");
		String rootDir=System.getProperty("user.dir");
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", rootDir+ "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", rootDir+ "/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", rootDir+ "/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/aside/div/form/input[2]")).click();
		//String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
	}
	
	@BeforeSuite
	public void reportSetup(){
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Regression Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS","Windows 10");
		extent.setSystemInfo("Host name" , "Propertyware");
		extent.setSystemInfo("Environment", "SAT");
		extent.setSystemInfo("User","Krishna");
	}
	@AfterMethod
	public void getResult(ITestResult result) throws IOException  {
		
			if(result.getStatus() == ITestResult.FAILURE)
			{
			 test.log(Status.FAIL, "Test Case Failed is: "+result.getName());
			 test.fail(result.getThrowable());
			 //test.fail("Test Failed");
			//test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test Case Failed", ExtentColor.RED));
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 String screenshotPath = UtilityMethods.takeScreenshot(driver, result.getName());
			 test.addScreenCaptureFromPath(screenshotPath);
			 }
			else if(result.getStatus() == ITestResult.STARTED){
				test.info("Test started");
			 }
			else if(result.getStatus() == ITestResult.SKIP){
				test.log(Status.SKIP, "Test Case Skipped is: "+result.getName());
				test.info("Test skipped");
			 }
			 else if(result.getStatus() == ITestResult.SUCCESS){
				 test.log(Status.PASS, "Test Case passed is: "+result.getName());
				 //test.pass("Test passed");
				 //test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
			 }
			
			//driver.close();
	}
	@AfterSuite
		public void tearDown(){
		extent.flush();
    }
}
