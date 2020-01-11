package pageObjects.properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class newUnit {
	
	public static WebElement unitName(WebDriver driver){
		return driver.findElement(By.name("entity.name"));
	}
	public static WebElement description(WebDriver driver){
		return driver.findElement(By.name("entity.comments"));
	}
	public static void state(WebDriver driver){
		Select state = new Select(driver.findElement(By.id("unitState")));
		state.selectByVisibleText("TX");
	}
	public static WebElement save(WebDriver driver){
		return driver.findElement(By.cssSelector("input[value=Save]"));
	}

}
