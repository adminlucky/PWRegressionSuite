package pageObjects.Leases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class RentersInsurance extends TestBase {
	
	public static WebElement rentersInsuranceTab(){
		return driver.findElement(By.xpath("//tr[1]/td[2]/form[1]/div[8]/a[9]/span[1]"));
	}
	public static WebElement recordPolicy(){
		return driver.findElement(By.xpath("//input[@value='Record Policy']"));
	}
	public static WebElement policyNumber(){
		return driver.findElement(By.xpath("//input[@id='policy.policyNumber']"));
	}
	public static void policyProvider(){
		(new Select(driver.findElement(By.xpath("//select[@name='policy.policyProvider']")))).selectByIndex(4);
	}
	public static void effectiveDate(){
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		driver.findElement(By.name("policy.effectiveDateAsString")).sendKeys(date);
	}
	public static void nextRenewalDate(){
		//String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 1);
		driver.findElement(By.name("policy.nextRenewalDateAsString")).sendKeys(simpleDateFormat1.format(cal.getTime()));
	}
	public static WebElement comments(){
		return driver.findElement(By.name("policy.comments"));
	}
	public static void save(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Save'])[1]")));
		driver.findElement(By.xpath("//form[1]/div[10]/div[2]/input[1]")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='editInsurancePolicyContainer']")));
	}
	
}
