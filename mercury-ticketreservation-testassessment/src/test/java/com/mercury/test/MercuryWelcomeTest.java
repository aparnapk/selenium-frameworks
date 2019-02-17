package com.mercury.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mercury.base.Base;
import com.mercury.pages.MercuryWelcomePage;

public class MercuryWelcomeTest extends Base{
	MercuryWelcomePage mercurywelcomepage;
	@BeforeMethod
	public void setUp(){
		initialization();
		mercurywelcomepage=new MercuryWelcomePage();
	}
	//Welcome page title validation
	@Test(priority=1)
	public void validateMercuryWelcomePageTitel() {
		String title=mercurywelcomepage.getPageTtile();
		Assert.assertEquals(title,"Welcome: Mercury Tours");
	}
	//Login method
	@Test(priority=2)
	public void validateMercuryLogin() {
		mercurywelcomepage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
