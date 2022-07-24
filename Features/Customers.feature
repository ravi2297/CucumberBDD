Feature: Customers

Background: 
Given user launch chrome browser
    When user open url "http://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then user can view Dashboard 
 
@smoke @regression   
Scenario: Add New Customers
    When user click on Customers Menu
    And click on Customers Menu Item
    And click on Add new Button
    Then user can view Add new customer page
    When user enter customer info
    And click on save button
    Then user can view cofirmation message "The new customer has been added successfully."
    And close browser

@sanity    
Scenario: Search customer by email
	 	When user click on Customers Menu
    And click on Customers Menu Item
    And enter customer email
    When click on search button
    Then user should found Email in the search table
    And close browser

@sanity    
Scenario: Search customer by name
	 	When user click on Customers Menu
    And click on Customers Menu Item
    And enter customer name
    When click on search button
    Then user should found name in the search table
    And close browser
    
