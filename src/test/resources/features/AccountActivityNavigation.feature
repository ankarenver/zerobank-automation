@navigation
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given user is on the login page
    When user logs in as an authorized user
    When user navigate to "Account Summary" page

  @navigate_to_check_dropdown
  Scenario Outline: "<nameOfLink>" account redirect
    When the user clicks on "<nameOfLink>" link on the Account Summary page
    Then page title should be "Zero - Account Activity"
    Then account dropdown default option must be "<nameOfLink>"
    Examples:
      | nameOfLink  |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |
