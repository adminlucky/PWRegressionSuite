package pageObjects.Leases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testBase.TestBase;

public class ApplySecDepCharges extends TestBase {
		
	public static WebElement applySecDepToCharges(){
		return driver.findElement(By.xpath("//a[contains(text(),'Apply SECDEP to Charges')]"));
	}
	public static boolean checkUnpaidChargesExist(){
		String charges = driver.findElement(By.xpath("//table[@class='list']//th[contains(text(),'Date')]")).getText();
		System.out.println(charges);
		return !charges.equalsIgnoreCase("No Charges");
	}
	public static WebElement amountDue(){
		return driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[5]"));
	}
	public static WebElement amount(){
		return driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[6]/input[1]"));
	}
	public static WebElement applySave(){
		return driver.findElement(By.xpath("//input[@value='Save']"));
	}
	
	
}
