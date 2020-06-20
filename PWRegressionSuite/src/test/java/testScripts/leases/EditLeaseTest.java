package testScripts.leases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.Leases.newLease;
import testBase.TestBase;
import utilities.UtilityMethods;

public class EditLeaseTest extends TestBase{
	
	@Test
	public void createLease() throws IOException{
	initialization();
	newLease.leases().click();
	}
}
