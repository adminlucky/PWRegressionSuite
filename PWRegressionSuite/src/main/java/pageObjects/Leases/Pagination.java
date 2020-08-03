package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testBase.TestBase;

public class Pagination extends TestBase {
	
	public static void rowsSetAsDefault(){
		for(int i=0; i<3; i++ ){
		(new Select(driver.findElement(By.xpath("//div[@class='paginationControls']//select")))).selectByIndex(i);
		
			if(driver.findElements(By.id("defaultPageSize")).size() > 0){
				driver.findElement(By.id("defaultPageSize")).click();
				break;
				}
			continue;
			}
	}
	public static WebElement nextPage(){
		return driver.findElement(By.xpath("//b[contains(text(),'next')]"));
	}
	public static WebElement previousPage(){
		return driver.findElement(By.xpath("//b[contains(text(),'previous')]"));
	}
	
}
