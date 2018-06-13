Feature: Login to facebook page
  User can login to facebook with valid username and password
  Background: User enter the Login page
    Given I am on Facebook login page

  @SmokeTest @NegativeTest
  Scenario Outline: : Login with invalid of username and password
    Given User enter Username as "<username>"
    And User enter Password as "<password>"
    When User click Login Button
    Then Login should be unsuccessful
    Examples:
      | username  | password  |
      | username1 | password1 |
      | username2 | password2 |