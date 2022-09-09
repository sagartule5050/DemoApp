package com.domain.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.domain.utility.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	// step 1:create instance variable of webdriver and properties

	public WebDriver driver;

	public Properties prop;
	
	

	// step 2 :create method for setup of browser Application
	@Parameters("browser")
	@BeforeClass
	public void setupApplication(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			// options.addArguments("--headless");         //testing will done without rendering UI
			options.addArguments("--incognito");
			options.addArguments("--disabled-notifications");

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);

			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
			driver = new FirefoxDriver(options);
		}
	}

	// step 3: create method for closing the application

	@AfterClass
	public void closeApplication() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	// step 4: create a method for taking a screenShots when test fails
     @AfterMethod   //it will execute after execution of @Test method
	public void takesScreenShotsOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) { // ITestResult is a interface from testng

			Utility.captureScrenshots(driver, testResult. getName() ); // getname is method of Itestresult
		}
		
	}
     
    // Step4 : method for log4j
     @BeforeTest
     public static void loadlog4j() {
    	String log4jpath = System.getProperty("E:\\java program\\Maven_project_zerodha\\log4j.properties");
     
        PropertyConfigurator.configure(log4jpath) ;
     }
     
	//step 5: method reading config properties file
	
	public void readConfig() throws IOException {
		FileInputStream file = new FileInputStream("./src/test/resources/config/configuration.properties");
		prop = new Properties();
		prop.load(file);
          
	}

}
