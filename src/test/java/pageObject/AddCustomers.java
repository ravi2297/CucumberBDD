package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomers {

	WebDriver driver;
	
	public AddCustomers(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement CustomerMenu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement CustomerMenuItem;
	
	@FindBy(xpath="//a[normalize-space()='Add new']")
	WebElement AddNewBtn;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement Male;
	
	@FindBy(xpath="//input[@id='Gender_Female']")
	WebElement Female;
	
	@FindBy(xpath="//input[@id='DateOfBirth']")
	WebElement DateOfBirth;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement CompanyName;
	
	@FindBy(xpath="//input[@id='IsTaxExempt']")
	WebElement isTaxAttempt;
	
	@FindBy(xpath="//div[@class='input-group-append']//div[@role='listbox']")
	WebElement newsLetter;
	
	@FindBy(xpath="//div[@class='input-group-append input-group-required']//div[@role='listbox']")
	WebElement CustomerRoles;
	
	@FindBy(xpath="//select[@id='VendorId']")
	WebElement manageOfVendors;
	
	@FindBy(xpath="//input[@id='Active']")
	WebElement isActive;
	
	@FindBy(xpath="//textarea[@id='AdminComment']")
	WebElement AdminComment;
	
	@FindBy(xpath="//*[@name='save']")
	WebElement SaveBtn;
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickCustomerMenu()
	{
		CustomerMenu.click();
	}
	
	public void clickCustomerMenuItem()
	{
		CustomerMenuItem.click();
	}
	
	public void clickOnAddNewBtn()
	{
		AddNewBtn.click();
	}
	
	public void enterEmail(String text)
	{
		txtEmail.sendKeys(text);
	}
	
	public void enterPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void enterFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);;
	}
	
	public void enterLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void selectGender(String gender)
	{
		if (gender.equalsIgnoreCase("male"))
		{
			Male.click();
		}
		else if(gender.equalsIgnoreCase("Female"))
		{
			Female.click();
		}
		else
		{
			Male.click();
		}
	}
	
	public void enterDateOfBirth(String dob)
	{
		DateOfBirth.sendKeys("2/2/1997");;
	}
	
	public void enterCompanyName(String text)
	{
		CompanyName.sendKeys(text);;
	}
	
	public void TaxAttemptYes()
	{
		isTaxAttempt.click();
	}
	
	public void enterAdminContent(String txt)
	{
		AdminComment.sendKeys(txt);
	}
	
	public void clickOnSave()
	{
		SaveBtn.click();
	}
	
}
