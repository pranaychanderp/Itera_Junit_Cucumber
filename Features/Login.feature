Feature: Login in itera site

  @login @+ve
  Scenario: Testing Login with valid credentials
    Given Launch browser
    And Navigate URL
    When Click on Login Link
    Then Enter Username as "qwerty3"
    And Enter Password as "Password"
    And Click on Login button
    And Login Successfull

  @login @-ve
  Scenario: Testing Login with invalid credentials
    Given Launch browser
    And Navigate URL
    When Click on Login Link
    Then Enter Username as "qwerty3"
    And Enter Password as ""
    And Click on Login button
    But Login should fail

  @login @-ve
  Scenario: Testing Login with invalid credentials
    Given Launch browser
    And Navigate URL
    When Click on Login Link
    Then Enter Username as ""
    And Enter Password as "password"
    And Click on Login button
    But Login should fail
