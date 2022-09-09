package com.domain.tests;

import java.time.Duration;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.domain.base.Base_Class;
import com.domain.pages.DemoAppHomePage;
import com.domain.pages.DemoAppLoginPage;


public class DemoAppLoginTest extends Base_Class{
public DemoAppLoginPage login1;
public DemoAppHomePage home;
	
	SoftAssert soft = new SoftAssert();
	
	@Test(description = "Test DemoApp Login page" , priority = 1)
	
	public  void verifyKiteLoginPage1() {
		login1 = new DemoAppLoginPage(driver);
		
		driver.get("https://sakshingp.github.io/assignment/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Reporter.log("==========Application Started==========" , true);  
		
		soft.assertEquals(login1.getPageTitle(), "Login Form");
		soft.assertTrue(driver.getPageSource().contains("Login Form"));
		login1.set1UserId("Sagar");
		login1.setPassword("tule41");     
		login1.clickOnLoginButton();
		soft.assertAll();
		
	}
@Test(description = "Test DemoApp home page" , priority = 2)
	
	public  void verifyDemoappHomepage (){
		home = new DemoAppHomePage(driver);
		
login1 = new DemoAppLoginPage(driver);
		
		driver.get("https://sakshingp.github.io/assignment/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		login1.set1UserId("Sagar");
		login1.setPassword("tule41");     
		login1.clickOnLoginButton();
		
		home.clickOnAmount();
		
	}

}
