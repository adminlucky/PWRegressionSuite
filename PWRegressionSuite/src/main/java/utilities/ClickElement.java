package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickElement {
	
	public static void clickByXpath(WebDriver driver, String xpath){
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
	}
}
