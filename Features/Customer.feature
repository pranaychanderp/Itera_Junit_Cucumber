Feature: Adding Customer

Background: 
		Given Open browser
    And Open URL
    When Click on Login
    Then Input Username as "qwerty3"
    And Input Password as "Password"
    And Click on the Login button 
	
	@Customer @Add
  Scenario: Adding Customer Test
    And Click on Create New button
    And Input Customer Name as "ACP"
    And Input Customer Company as "TESLA"
    And Input Customer Address as "USA"
    And Input Customer City as "NY"
    And Input Customer Phone as "1234567890"
    And Input Customer Email as "PPC@Test.com"
    And Click on Create button
    And Verify customer is added in the list
    And Click on Logout Link
    
   	@Customer @Edit
   Scenario: Editing Customer Test
		And Input the customer name or email in search box
		And Click on Search button
		And Click on Edit
		And Edit the customer details
		And Click on Save button
		And Verify updated details is updated in the table
		And Click on Logout Link
		
		@Customer @Delete
   Scenario: Deleting Customer Test
		And Input the customer name or email in search box
		And Click on Search button
		And Click on Delete
		And Click on Delete button
		And Verify updated details is updated in the table
		And Click on Logout Link
		
		