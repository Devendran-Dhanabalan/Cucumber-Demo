Feature: Test the Restful API for the web service
  Background: Using the base URL https://httpbin.org for testing
    Given User want to test web service of Base URL "https://httpbin.org"
    Scenario: User send a GET request
      When User send a "GET" request "/get"
      Then The response code should be "200"