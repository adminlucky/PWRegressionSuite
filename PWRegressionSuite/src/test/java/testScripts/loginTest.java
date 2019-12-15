package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class loginTest {

	@BeforeSuite
	public void loginPW(){
	System.setProperty("webdriver.chrome.driver","C:\\Personal\\Softwares\\Drivers\\chromedriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://sat.propertyware.com/pw/login.jsp");
	driver.findElement(By.name("email")).sendKeys("mdeavers@psatlanta.com");
	driver.findElement(By.name("password")).sendKeys("Realpage12");
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/aside/div/form/input[2]")).click();
	

	}
}
