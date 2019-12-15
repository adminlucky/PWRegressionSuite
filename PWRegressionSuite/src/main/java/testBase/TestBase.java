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

public class TestBase extends config_Reader {
	public static WebDriver driver;
			
	public static void initialization() throws IOException
	{
		readConfigFile();
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Personal\\Softwares\\Drivers\\chromedriver\\chromedriver.exe");
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
	}
	public static String takeScreenshot(WebDriver driver, String testMethodName) throws IOException{
		String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"/Screenshots/"+testMethodName+"_"+date+".jpg";
        FileUtils.copyFile(scrFile, new File(destination));
        return destination;
	}
}
