Feature: Test Login feature

  Background:
    Given I am on OpenCart login page

  @Login
  Scenario: Successful login
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully