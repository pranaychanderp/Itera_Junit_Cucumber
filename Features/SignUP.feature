Feature: Signing up in itera site

  @signup
  Scenario: Testing Sign up 
    Given Launch the browser
    And Navigate to URL
    When Click on Sign Up Link
    Then Input Firstname
    And Input Surname
    And Input Epost
    And Input Mobile
    And Input Username
    And Input Password
    And Input Confirm Password
    And Click on Submit Button
