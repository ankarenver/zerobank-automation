@Find_Transactions
Feature: Find Transactions in Account Activity


  Background:
    Given user is on the login page
    When user logs in as an authorized user
    When user navigate to "Account Activity" page
    Given the user accesses the Find Transactions tab


  Scenario: Search date range
    When the user enters date range from “from” to “to”
      | from | 2012-09-01 |
      | to   | 2012-09-06 |
    And clicks search
    Then results table should only show transactions dates between “from” to “to”
      | from | 2012-09-01 |
      | to   | 2012-09-06 |

    And the results should be sorted by most recent date
    And the results table should only not contain transactions dated “2012-09-01”
