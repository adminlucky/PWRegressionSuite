package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {
	
	public static String takeScreenshot(WebDriver driver, String testMethodName) {
		String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		String destination = System.getProperty("user.dir")+"/Screenshots/"+testMethodName+"_"+date+".jpg";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(sourceFile, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}
	
	//improved on 06/23/2020
	public static WebElement waitForElementToLoad(WebDriver driver, String xpathLocator){
		WebDriverWait wait=new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
		
	}
	
	// Need to generalize for all the locator types
	public static void waitForElementToBeClickable(WebDriver driver, String xpathLocator){
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocator)));
		
		// Less preferred option
		/* JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpathLocator)));*/
	}
	public static void waitForElementToBeInvisible(WebDriver driver, String xpathLocator){
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathLocator)));
	}
	//Need to change the method to no argument method
	public static void scrollUp(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0, -1500);");
	}
	public static void scrollDownHalf(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 600)");
	}
	
	public static void scrollDown(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public static void pageRefresh(WebDriver driver){
		driver.navigate().refresh();
	}
	
	
	public static int randomNumber(){
		Random rand = new Random(); 
		// Generate random integers in range 0 to 9999 
        return rand.nextInt(10000); 
	}
}



	//Need to improve the efficiency and purpose
	/*public static void clickByXpath(WebDriver driver, String xpath){
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
	}*/
