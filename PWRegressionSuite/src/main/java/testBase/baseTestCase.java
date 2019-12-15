package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class baseTestCase {

	    private WebDriver driver;

	    public WebDriver getDriver() {
	            return driver;
	}

	    @BeforeTest
	    public void createDriver() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Personal\\Softwares\\Drivers\\chromedriver\\chromedriver.exe");
	            WebDriver driver=new ChromeDriver();
	            driver.get("https://sat.propertyware.com/pw/login.jsp");
	            
	    }

	    @AfterMethod
	        public void tearDownDriver() {
	        if (driver != null)
	        {
	                try
	                {
	                    driver.quit();
	                }
	                catch (WebDriverException e) {
	                    System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****");
	                    System.out.println(e);
	                }

	        }
	    }
}
