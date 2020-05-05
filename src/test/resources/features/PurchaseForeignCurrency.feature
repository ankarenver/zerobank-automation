@Purchase_Foreign_Currency
Feature: Purchase Foreign Currency

  Background:
    Given user is on the login page
    When user logs in as an authorized user
    When user navigate to "Pay Bills" page
    Given the user accesses the Purchase foreign currency cash tab

  @Available_currencies
  Scenario: Available currencies

    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |


  @Error_message_for_not_selecting_currency
  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed

  @Error_message_for_not_entering_value
  Scenario: Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error message should be displayed