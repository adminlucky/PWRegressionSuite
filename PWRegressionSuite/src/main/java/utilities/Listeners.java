package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.TestBase;


public class Listeners extends TestBase implements ITestListener {
  
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
			
	@Override
	public void onStart(ITestContext testContext){
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"//Reports//myReport.html");
		//extra line
		//htmlReporter.setAppendExisting(true);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Regression Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		//htmlReporter.
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		//extra line
		//extent.setReportUsesManualConfiguration(true);
		extent.setSystemInfo("Host name" , "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User","Krishna");
		System.out.println("onStart method completed");
		//testContext.setAttribute("WebDriver", this.driver);
	}
	@Override
	public void onTestSuccess(ITestResult result){
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test case passed is : "+result.getName());
		
		System.out.println("onTestSuccess method completed");
		}
	@Override
	public void onTestFailure(ITestResult result){
		
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case failed is : "+result.getName());
		test.log(Status.FAIL, "Test case failed reason : "+result.getThrowable());
		
		String screenshotPath = takeScreenshot(result.getMethod().getMethodName());
		//test.log(Status.FAIL, test.addScreenCapture(capture(driver))+"test failed"));
		System.out.println("onTestFailure method completed");
       // extra browser is opening, report not proper and screenshots are not taken
	}
	@Override
	public void onTestSkipped(ITestResult result){
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped is : "+result.getName());
		System.out.println("onTestSkipped method completed");
	}
	@Override
	public void onFinish(ITestContext testContext){
		extent.flush();
		System.out.println("onFinish method completed");
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
}
