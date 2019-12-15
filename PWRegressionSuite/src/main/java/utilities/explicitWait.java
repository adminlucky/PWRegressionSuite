package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitWait {
	public static void waitForElementToLoad(WebDriver driver, String xpathLocator){
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
		//https://stackoverflow.com/questions/35805186/not-able-to-make-a-own-method-to-use-explicit-wait-method-of-selenium
	}

	
}
