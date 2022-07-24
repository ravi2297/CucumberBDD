package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class SearchCustomerPage {

	WebDriver driver;
	
	public SearchCustomerPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(id="SearchEmail")
	WebElement EmailField;
	
	@FindBy(id="SearchFirstName")
	WebElement FirstNameField;
	
	@FindBy(id="search-customers")
	WebElement SearchBtn;
	
	public void enterEmailAddress(String email)
	{
		EmailField.sendKeys(email);
	}
	
	public void enterFirstName(String fname)
	{
		FirstNameField.sendKeys(fname);
	}
	
	public void clickOnSearchBtn()
	{
		SearchBtn.click();
	}
	
	@SuppressWarnings("deprecation")
	public void verifyEmailPresent()
	{
		driver.navigate().refresh();
		List<WebElement> Emails=driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		
		String ActualEmail=EmailField.getText();
		
		for(WebElement i:Emails)
		{
			String value=i.getText();
			
			if(value.contains(ActualEmail))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
	
	}
	
	
	@SuppressWarnings("deprecation")
	public void verifyNamePresent()
	{
		driver.navigate().refresh();
		List<WebElement> Names=driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
		
		String ActualName=FirstNameField.getText();
		
		for(WebElement a:Names)
		{
			String value=a.getText();
			
			if(value.contains(ActualName))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
	
	}
	
	
}
