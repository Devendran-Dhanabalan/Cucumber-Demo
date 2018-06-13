Feature: User test put request with form input
  Background: Using the base URL https://httpbin.org for testing
    Given User want to test web service of Base URL "https://httpbin.org"
  Scenario: User send a POST request with filling the form
    When User send a "POST" request "/post" with data
      | custname               | Tom                 |
      | custtel                | 713-212-3312        |
      | custemail              | someone@someone.com |
    Then The response code should be "200"
    And The response "form" should content data:
      | custname               | Tom                 |
      | custtel                | 713-212-3312        |
      | custemail              | someone@someone.com |