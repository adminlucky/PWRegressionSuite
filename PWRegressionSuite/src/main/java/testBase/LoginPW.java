package testBase;

import pageObjects.Leases.Login;

public class LoginPW extends TestBase {
	
	public static void loginPW(){
	
	Login.launchBrowser();	
	Login.username().sendKeys(prop.getProperty("username"));
	Login.password().sendKeys(prop.getProperty("password"));
	Login.signIn().click();
	
	}

}
