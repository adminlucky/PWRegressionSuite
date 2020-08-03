package testScripts.leases;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.Leases.AddAutoCharge;
import pageObjects.Leases.GlobalSearch;
import pageObjects.Leases.Login;
import pageObjects.Leases.MoveoutAndTerminateLease;
import pageObjects.Leases.TotalLinks;
import pageObjects.Leases.createCharge;
import pageObjects.Leases.newLease;
import testBase.TestBase;

public class SearchTagTest extends TestBase {
	
	//This test is to create a search tag for a lease and verify global search with that tag 
	@Test
	public void searchTagTest() throws InterruptedException{
		test=extent.createTest("SearchTagTest");
		Login.refreshPage();
		String searchTag = "TermAAA";
		AddAutoCharge.waitForLeases();
		newLease.leases().click();
		TotalLinks.terminatedLeases();
		MoveoutAndTerminateLease.firstLease().click();
		GlobalSearch.searchTag().click();
		GlobalSearch.searchTagText().sendKeys(Keys.CONTROL, "a");
		GlobalSearch.searchTagText().sendKeys(searchTag);
		GlobalSearch.saveSearchTag().click();
		GlobalSearch.globalSearch().sendKeys(searchTag);
		GlobalSearch.clickOnExactLease();
	}
}
