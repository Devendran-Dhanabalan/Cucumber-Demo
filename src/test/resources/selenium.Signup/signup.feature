Feature: New user registration.
  Verify that the new user registration is unsuccessful after passing the incorrect inputs.
  Background: User is on the registration page
    Given I am on a new user registration page
    Scenario: Enter invalid data
      When I enter invalid data on the page
        | Fields                 | Values              |
        | First Name             | Tom                 |
        | Last Name              | Kenny               |
        | Email Address          | someone@someone.com |
        | Re-enter Email Address | someone@someone.com |
        | Password               | Password1           |
        | Birthdate              | 5/12/1992           |
        | Sex                    | Male                |
      And I click Sign up button
      Then the user registration should be unsuccessful