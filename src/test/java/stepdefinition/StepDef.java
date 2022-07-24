package stepdefinition;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pageObject.AddCustomers;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;
import utilities.ConfigReader;

public class StepDef extends BaseClass {
	
	@Before
	public void setUp() throws Exception
	{
		//initialize properties
		
		config = new ConfigReader();
		String browser = config.getBrowser();
		
		// launch browser 
		
		switch(browser.toLowerCase())
		{
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				break;
			default:
				driver=null;
				break;
		}
		
		driver.manage().window().maximize();
		
		// initialize logger
		
		Log = LogManager.getLogger("StepDef");
		System.out.println(" * * * before - - setup method is executed * * *");
		
	    Log.info("setup executed");
	}

	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
	    
	    Loginpg=new LoginPage(driver);
	    Addcustpg=new AddCustomers(driver);
	    Searchcustpg=new SearchCustomerPage(driver);
	    Log.info("Browser Launched");
	}

	@When("user open url {string}")
	public void user_open_url(String url) {
	    driver.get(url);
	    Log.info("url opened");
	}

	@When("user enters email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String pwd) {
		Loginpg.enterEmail(emailAdd);
	    Loginpg.enterPassword(pwd);
	    Log.info("email and password entered");
	}

	@When("click on Login")
	public void click_on_login() {
	    Loginpg.clickOnLoginBtn();
	    Log.info("Login Successful");
	}

	@SuppressWarnings("deprecation")
	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle))
			{
				Assert.assertTrue(true);	// pass
				Log.warn("Test Passed : Page title Matched");
			}
		else
			{
				Assert.assertTrue(false);	// fail
				Log.warn("Test Failed : Page title is not Matched");
			}
	}

	@When("user click on logout link")
	public void user_click_on_logout_link() {
	    Loginpg.clickOnLogoutBtn();
	    Log.info("Logout successful");
	}

	
	
	//_____________________Add New Customers_________________________________
	
	@Then("user can view Dashboard")
	public void user_can_view_dashboard() {
	    String ActualTitle = Addcustpg.getPageTitle();
	    String ExpectedTitle = "Dashboard / nopCommerce administration";
	    
	    if(ActualTitle.contains(ExpectedTitle))
	    {
	    	Log.info("user see Dashboard");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Log.info("user is not able to see dashboard");
	    	Assert.assertTrue(false);
	    }
	}

	@When("user click on Customers Menu")
	public void user_click_on_customers_menu() {
	    Addcustpg.clickCustomerMenu();
	    Log.info("user click on customer menu");
	}

	@When("click on Customers Menu Item")
	public void click_on_customers_menu_item() {
	    Addcustpg.clickCustomerMenuItem();
	    Log.info("user click on Customer Menu item");
	    
	}

	@When("click on Add new Button")
	public void click_on_add_new_button() {
	    Addcustpg.clickOnAddNewBtn();
	    Log.info("user click on Add new Button");
	}

	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	    String ExpectedTitle = "Add a new customer / nopCommerce administration";
	    String ActualTitle = Addcustpg.getPageTitle();
	    
	    if(ActualTitle.contains(ExpectedTitle))
	    {
	    	Log.info("user can view add new customer Page");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Log.info("user not able to view add new customer Page");
	    	Assert.assertTrue(false);
	    }
	}

	@When("user enter customer info")
	public void user_enter_customer_info() {
	    Addcustpg.enterEmail(randomEmailGen() + "@gmail.com");
	    Addcustpg.enterPassword("1234859594");
	    Addcustpg.enterFirstName("harshal");
	    Addcustpg.enterLastName("sonawane");
	    Addcustpg.selectGender("Male");
	    Addcustpg.enterDateOfBirth("22/3/2000");
	    Addcustpg.TaxAttemptYes();
	    Addcustpg.enterAdminContent("hello bro, what's up?, i miss you so much");
	    Log.info("user successfully enter customer information");
	}

	@When("click on save button")
	public void click_on_save_button() {
	    Addcustpg.clickOnSave();
	    Log.info("click on save");
	}

	@Then("user can view cofirmation message {string}")
	public void user_can_view_cofirmation_message(String string) {
	   String source = driver.getPageSource();
	   if(source.contains("The new customer has been added successfully."))
	   {
	    	
		   Assert.assertTrue(true);
		   Log.info("user can view confirmation message");
	   }
	   else
	   {
		   Assert.assertTrue(false);
	       Log.info("user not able to view confirmation message");
	   }
	}
	
//_________________Search Customers__________________________________________________
	
	@When("enter customer email")
	public void enter_customer_email() {
	   Searchcustpg.enterEmailAddress("victoria_victoria@nopCommerce.com");
	   Log.info("Customer email entered successfully");
	}
	
	@And("enter customer name")
	public void enter_customer_name()
	{
		Searchcustpg.enterFirstName("victoria");
		Log.info("Customer name entered successfully");
	}

	@When("click on search button")
	public void click_on_search_button() {
	    Searchcustpg.clickOnSearchBtn();
	    Log.info("click on search");
	}

	@Then("user should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
	    Searchcustpg.verifyEmailPresent();
	    Log.info("user found email in search table");
	}
	
	@Then("user should found name in the search table")
	public void user_should_found_name_in_the_search_table() {
	    Searchcustpg.verifyNamePresent();
	    Log.info("user found name in search table");
	}
	
//	@After
//	public void tearDown(Scenario sc) 
//	{
//		if (sc.isFailed()==true)
//		{
//		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(src,new File("E:\\\\sample\\\\BDDFinalProject\\\\Screenshots\\\\failedScreenshot.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(" * * * After - - tearDown method is executed * * *");
//		}
//		
//		
//		driver.quit();
//	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		if(scenario.isFailed()==true)
		{
			final byte[] Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		//attach image file report(data, media type, name of the attachment)	
			scenario.attach(Screenshot, "image/png" , scenario.getName());
		}
	}
	
//	@AfterStep
//	public void afterstep()
//	{
//		System.out.println("______ _ _ I WILL EXECUTE AFTER EACH STEP _ _ _ _ _");
//		
//	}
	
	
}
