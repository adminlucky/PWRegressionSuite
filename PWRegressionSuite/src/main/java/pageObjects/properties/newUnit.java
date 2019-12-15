package pageObjects.properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class newUnit {
	
	private static WebElement element = null;
	private static WebDriver driver = null;
	
	public static WebElement unitName(WebDriver driver){
		element = driver.findElement(By.name("entity.name"));
		return element;
	}
	public static WebElement description(WebDriver driver){
		element = driver.findElement(By.name("entity.comments"));
		return element;
	}
	public static void state(WebDriver driver){
		Select state = new Select(driver.findElement(By.id("unitState")));
		state.selectByVisibleText("TX");
	}
	public static WebElement save(WebDriver driver){
		element = driver.findElement(By.cssSelector("input[value=Save]"));
		return element;
	}

}
