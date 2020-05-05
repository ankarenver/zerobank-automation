@Find_Transactions
Feature: Find Transactions in Account Activity


  Background:
    Given user is on the login page
    When user logs in as an authorized user
    When user navigate to "Account Activity" page
    Given the user accesses the Find Transactions tab

  @find_transactions_search_date_range
  Scenario: Search date range
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"


  @find_transactions_search_description
  Scenario: Search description
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE"
    And clicks search
    Then results table should only show descriptions containing "OFFICE"
    But results table should not show descriptions containing "ONLINE"


  @find_transactions_search_description_case_insensitive
  Scenario: Search description case insensitive
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "online"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"


  @type
  Scenario: Type
    And clicks search
    Then results table should show at least one result under "Deposit"
    Then results table should show at least one result under "Withdrawal"

    When user selects type "Deposit"
    And clicks search
    Then results table should show at least one result under "Deposit"
    But results table should show no result under "Withdrawal"

    When user selects type "Withdrawal"
    And clicks search
    Then results table should show at least one result under "Withdrawal"
    But results table should show no result under "Deposit"





