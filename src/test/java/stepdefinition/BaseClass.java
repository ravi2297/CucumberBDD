package stepdefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObject.AddCustomers;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;
import utilities.ConfigReader;

public class BaseClass {

	public static WebDriver driver;
	public LoginPage Loginpg;
	public AddCustomers Addcustpg;
	public SearchCustomerPage Searchcustpg;
	public static Logger Log;
	public ConfigReader config;
	public String randomEmailGen()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
	
}
