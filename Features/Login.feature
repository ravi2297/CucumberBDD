Feature: Login Functionality

	@smoke	
  Scenario: successful Login with valid credentials
    Given user launch chrome browser
    When user open url "http://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When user click on logout link
    Then Page title should be "Your store. Login"
    And close browser

  ## Data driven testing
  @regression
  Scenario Outline: successful Login with valid credentials DDT
    Given user launch chrome browser
    When user open url "http://admin-demo.nopcommerce.com/login"
    And user enters email as "<email>" and Password as "<password>"
    And click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When user click on logout link
    Then Page title should be "Your store. Login"
    And close browser
    
   Examples: 
   |email|password|
   |admin@yourstore.com|admin|
   |test@yourstore.com|admin|
   
