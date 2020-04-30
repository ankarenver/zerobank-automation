@account_summary
Feature: Account summary

  Background:
    Given user is on the login page
    When user logs in as an authorized user
    When user navigate to "Account Summary" page

  @account_summary_title
  Scenario: Account summary page should have the title Zero – Account summary.
    Then page title should be "Zero - Account Summary"

  @account_summary_account_types
  Scenario: Account summary page should have to following account types: Cash Accounts, Investment Accounts, Credit Accounts, Loan Accounts.
    Then user should see following account types:
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  @account_summary_credit_account_columns
  Scenario: Credit Accounts table must have columns Account, Credit Card and Balance.
    Then credit accounts table must have following columns:
      | Account     |
      | Credit Card |
      | Balance     |