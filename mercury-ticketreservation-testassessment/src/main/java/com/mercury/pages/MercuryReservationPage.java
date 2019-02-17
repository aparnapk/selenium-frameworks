package com.mercury.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.mercury.base.Base;

public class MercuryReservationPage extends Base{
	//Reservation Page WebElements
	@FindBy(name="fromPort")
	WebElement departFrom;
	
	@FindBy(name="toPort")
	WebElement arriveIn;
	
	@FindBy(name="findFlights")
	WebElement continueBtn;
	
	@FindBy(name="reserveFlights")
	WebElement reserveFlights;
	
	@FindBy(name="passFirst0")
	WebElement firstName;
	
	@FindBy(name="passLast0")
	WebElement lastName;
	
	@FindBy(name="creditnumber")
	WebElement creditCard;
	
	@FindBy(name="ticketLess")
	WebElement ticketLess;
	
	@FindBy(name="buyFlights")
	WebElement buyFlights;
	
	//Page Factory initialization
	public MercuryReservationPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Reservation Page Actions
	public String getPageTtile() {
		return(driver.getTitle());
	}
	
	public void clickOnTripType() {
		List<WebElement> tripType = driver.findElements(By.name("tripType"));
		tripType.get(1).click();
		
	}
	
	public void choosePlaces(String from,String to) {
		Select select =new Select(departFrom);
		select.selectByVisibleText(from);
		select =new Select(arriveIn);
		select.selectByVisibleText(to);
	}
	
	public void clickOnServiceType() {
		List<WebElement> serviceClass = driver.findElements(By.name("servClass"));
		serviceClass.get(2).click();
	}
	
	public String clickOnContinue() {
		continueBtn.click();
		return(driver.getTitle());
	}
	
	public String clickOnreserveFlight() {
		reserveFlights.click();
		return(driver.getTitle());
	}
	
	public void enterBookingInfo(String fname,String lname,String creditcard) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		creditCard.sendKeys(creditcard);
	}
	
	public void clickOnticketless() {
		ticketLess.click();
	}
	public String finalizeBooking() {
		buyFlights.click();
		return(driver.getTitle());
	}

}
