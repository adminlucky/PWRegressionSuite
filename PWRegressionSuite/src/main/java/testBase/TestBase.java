package testBase;
import dataReader.config_Reader;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase extends config_Reader {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
			
	public static void initialization() throws IOException
	{
		readConfigFile();
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Personal\\Softwares\\Drivers\\chromedriver\\chromedriver_79.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Personal\\Softwares\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/aside/div/form/input[2]")).click();
		//String filepath = System.getProperty("user.dir")+"/src/main/java/testdata/PWData.xlsx";
	}
	public static String takeScreenshot(WebDriver driver, String testMethodName) throws IOException{
		String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"/Screenshots/"+testMethodName+"_"+date+".jpg";
        FileUtils.copyFile(scrFile, new File(destination));
        return destination;
	}
	
	@BeforeSuite
	public void reportSetup(){
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
	public void getResult(ITestResult result) throws IOException  {
		
			if(result.getStatus() == ITestResult.FAILURE)
			{
			 test.log(Status.FAIL, "Test Case Failed is: "+result.getName());
			 test.fail(result.getThrowable());
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 String screenshotPath = TestBase.takeScreenshot(driver, result.getName());
			 test.addScreenCaptureFromPath(screenshotPath);
			 }
			else if(result.getStatus() == ITestResult.SKIP){
				test.log(Status.SKIP, "Test Case Skipped is: "+result.getName());
			 }
			 else if(result.getStatus() == ITestResult.SUCCESS){
				 test.log(Status.PASS, "Test Case passed is: "+result.getName());
			 }
			
			driver.close();
	}
	@AfterSuite
		public void tearDown(){
		extent.flush();
    }
}
