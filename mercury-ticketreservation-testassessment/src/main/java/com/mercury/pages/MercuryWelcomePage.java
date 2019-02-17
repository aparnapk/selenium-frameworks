package com.mercury.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mercury.base.Base;

public class MercuryWelcomePage extends Base{
	//Welcome page web elemt
	@FindBy(name="userName")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="login")
	WebElement signInBtn;

	//Page Factory initialization
	public MercuryWelcomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Welcome Page actions
	public String getPageTtile() {
		return(driver.getTitle());
	}
	public MercuryReservationPage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInBtn.click();
		return new MercuryReservationPage();
	}

}
