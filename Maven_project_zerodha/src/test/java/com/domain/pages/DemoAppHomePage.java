package com.domain.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoAppHomePage {
	public WebDriver driver;
	public DemoAppHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

			// declaration
			@FindBy(xpath="//th[@id='amount']") 
			private WebElement amount;
			
			@FindBy(xpath="//table[@id='transactionsTable']/tbody/tr") 
			private WebElement webtable;
			
			
			public void
			clickOnAmount() {
				amount.click();
				
			}
			
			public boolean verifySortingValue() {
				
				String[] expectedsortedvalues = {"- 320.00 USD ","- 244.00 USD "," + 17.99 USD ","+ 340.00 USD ","+ 952.23 USD" ,"+ 1,250.00 USD"};
				
				ArrayList<String> list = new ArrayList<String>();
				
				
				
				List<WebElement> row = driver.findElements(By.xpath("//table[@id='transactionsTable']/tbody/tr"));
				int rowCount=row.size() ;
				for (int i = 1; i <=rowCount; i++) {

					String value = driver.findElement(By.xpath("//table[@id='transactionsTable']/tbody/tr["+i+"]/td[5]")).getText();
					
					list.add(value);
					
				}
				
				String[] valuesAftersort = new String[list.size()];
				
				list.toArray(valuesAftersort);
				
				return  Arrays.equals(expectedsortedvalues, valuesAftersort);
				
				}
				

			
}
