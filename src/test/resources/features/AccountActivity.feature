@account_activity
Feature: account activity

  Background:
    Given user is on the login page
    When user logs in as an authorized user
    When user navigate to "Account Activity" page

  @account_activity_check_dropdown_options
  Scenario: Account Activity page should have the title Zero – Account Activity.
    Then page title should be "Zero - Account Activity"
    Then account dropdown default option must be "Savings"
    And account dropdown should have following options:
      | Savings     |
      | Checking    |
 #     | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    And transactions table should have column names as follow:
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
