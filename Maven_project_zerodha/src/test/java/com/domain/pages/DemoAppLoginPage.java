package com.domain.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoAppLoginPage {
	// step1 : create a instance of web driver

		public WebDriver driver;
		public static Logger Logger ;

		// step 2 : declare web element variable as a private and locate them by @findby
		// annotation
		@FindBy(xpath = "//h4[@class = 'auth-header']")
		private WebElement heading;

		@FindBy(xpath = "//input[@id='username']")
		private WebElement username;

		@FindBy(xpath = "//input[@id='password']")
		private WebElement password;

		@FindBy(xpath = "//button[@id = 'log-in']")
		private WebElement loginbtn;
		
		@FindBy(xpath = "//input[@class = 'form-check-input']")
		private WebElement rememberMe;


		
		

		// step 3: create a constructor for initializing web driver

		public DemoAppLoginPage(WebDriver driver) {
			this.driver = driver;

			PageFactory.initElements(driver, this); // lazy initialization
			Logger = Logger.getLogger(DemoAppLoginPage.class.getName());
		}

		// step 4 :creating methods for performing actions on webelements

		public void set1UserId(String userId) {
			Logger.info("Entering UserId");
			username.clear();
			username.sendKeys(userId);

		}

		public void setPassword(String pass) {
			Logger.info("Entering password");
			password.clear();
			password.sendKeys(pass);

		}

		public void clickOnLoginButton() {
			loginbtn.click();
		}

		

		public String getPageTitle() {
			return driver.getTitle();

		}

		public boolean verifyUserIDField() {
			return username.isEnabled();
		}

		public boolean verifypasswordField() {
			return password.isEnabled();
		}

		public boolean verifyLoginbtn() {
			return loginbtn.isEnabled();
		}

		public boolean verifyRememberMeCheckbox() {
			return rememberMe.isEnabled();
		}


}
