package com.mercury.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mercury.base.Base;
import com.mercury.pages.MercuryReservationPage;
import com.mercury.pages.MercuryWelcomePage;

public class MercuryReservationTest extends Base{
	MercuryWelcomePage mercurywelcomepage;
	MercuryReservationPage mercuryreservationpage;
	
	@BeforeMethod
	public void setUp(){
		initialization();
		mercurywelcomepage=new MercuryWelcomePage();
		mercuryreservationpage=mercurywelcomepage.login("mercury","mercury");
	}
	//Reservation page title validation
	@Test(priority=1)
	public void validateMercuryFlightReservationPagetitle() {
		String title=mercuryreservationpage.getPageTtile();
		Assert.assertEquals(title,"Find a Flight: Mercury Tours:");
	}
	
	//End to End test case which demonstrat flight book flow
	@Test(priority=2)
	public void validateMercuryFlightReservation() {
		String pageTtile;
		pageTtile=mercuryreservationpage.getPageTtile();
		Assert.assertEquals(pageTtile,"Find a Flight: Mercury Tours:");
		mercuryreservationpage.clickOnTripType();
		mercuryreservationpage.choosePlaces(prop.getProperty("fromplace"),prop.getProperty("toplace"));
		mercuryreservationpage.clickOnServiceType();
		pageTtile=mercuryreservationpage.clickOnContinue();
		Assert.assertEquals(pageTtile,"Select a Flight: Mercury Tours");
		pageTtile=mercuryreservationpage.clickOnreserveFlight();
		Assert.assertEquals(pageTtile,"Book a Flight: Mercury Tours");
		mercuryreservationpage.enterBookingInfo(prop.getProperty("fname"),prop.getProperty("lname"),prop.getProperty("creditcard"));
		mercuryreservationpage.clickOnticketless();
		pageTtile=mercuryreservationpage.finalizeBooking();
		Assert.assertEquals(pageTtile,"Flight Confirmation: Mercury Tours");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
