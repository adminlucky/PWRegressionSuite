package pageObjects.Leases;

import org.testng.annotations.Test;
import pageObjects.Leases.NewLease;
import testBase.TestBase;

public class SampleTest extends TestBase {
	
	@Test
	public void refresh() throws InterruptedException{
		test=extent.createTest("refresh");
		NewLease.leases().click();
		NewLease.newLeaseLink().click();
		/*String url1 = driver.getCurrentUrl();
		System.out.println("Current url is : "+url1);
		String url2 = driver.getCurrentUrl().split("\\?")[0];
		System.out.println("url after trim is : "+url2);*/
		driver.get("https://sat.propertyware.com/pw/leases/leases_home.do");
	}

}
