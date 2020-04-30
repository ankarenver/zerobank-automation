@pay_bills
Feature: pay bills

  Background:
    Given user is on the login page
    When user logs in as an authorized user
    When user navigate to "Pay Bills" page

  @pay_bills_verify_title
  Scenario: Account Activity page should have the title Zero – Pay Bills.
    Then page title should be "Zero - Pay Bills"

  @pay_bill_successful_pay_operation
  Scenario Outline: When user completes a successful Pay operation, The payment was successfully submitted. should be displayed.
    Then make pay with following info:
      | Payee   | Account   | Amount   | Date   | Description   | Verify   |
      | <payee> | <account> | <amount> | <date> | <description> | <verify> |

    Examples:
      | payee           | account     | amount | date       | description  | verify                                  |
      | Sprint          | Savings     | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Sprint          | Checking    | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Sprint          | Loan        | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Sprint          | Credit Card | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Sprint          | Brokerage   | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Bank of America | Savings     | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Bank of America | Checking    | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Bank of America | Loan        | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Bank of America | Credit Card | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Bank of America | Brokerage   | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Apple           | Savings     | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Apple           | Checking    | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Apple           | Loan        | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Apple           | Credit Card | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Apple           | Brokerage   | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Wells Fargo     | Savings     | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Wells Fargo     | Checking    | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Wells Fargo     | Loan        | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Wells Fargo     | Credit Card | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |
      | Wells Fargo     | Brokerage   | 1000   | 2020-05-10 | Test payment | The payment was successfully submitted. |


  @pay_bill_un_successful_pay_operation
  Scenario Outline: When user tries to make a payment without entering the amount or date, Please fill out this field message! should be displayed.
    Then can not make pay with following info:
      | Payee   | Account   | Amount   | Date   | Description   | Verify   |
      | <payee> | <account> | <amount> | <date> | <description> | <verify> |

    Examples:
      | payee           | account     | amount | date       | description  | verify                      |
      | Sprint          | Savings     | 1000   |            | Test payment | Please fill out this field. |
      | Sprint          | Savings     |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Sprint          | Checking    | 1000   |            | Test payment | Please fill out this field. |
      | Sprint          | Checking    |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Sprint          | Loan        | 1000   |            | Test payment | Please fill out this field. |
      | Sprint          | Loan        |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Sprint          | Credit Card | 1000   |            | Test payment | Please fill out this field. |
      | Sprint          | Credit Card |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Sprint          | Brokerage   | 1000   |            | Test payment | Please fill out this field. |
      | Sprint          | Brokerage   |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Bank of America | Savings     | 1000   |            | Test payment | Please fill out this field. |
      | Bank of America | Savings     |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Bank of America | Checking    | 1000   |            | Test payment | Please fill out this field. |
      | Bank of America | Checking    |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Bank of America | Loan        | 1000   |            | Test payment | Please fill out this field. |
      | Bank of America | Loan        |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Bank of America | Credit Card | 1000   |            | Test payment | Please fill out this field. |
      | Bank of America | Credit Card |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Bank of America | Brokerage   | 1000   |            | Test payment | Please fill out this field. |
      | Bank of America | Brokerage   |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Apple           | Savings     | 1000   |            | Test payment | Please fill out this field. |
      | Apple           | Savings     |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Apple           | Checking    | 1000   |            | Test payment | Please fill out this field. |
      | Apple           | Checking    |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Apple           | Loan        | 1000   |            | Test payment | Please fill out this field. |
      | Apple           | Loan        |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Apple           | Credit Card | 1000   |            | Test payment | Please fill out this field. |
      | Apple           | Credit Card |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Apple           | Brokerage   | 1000   |            | Test payment | Please fill out this field. |
      | Apple           | Brokerage   |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Wells Fargo     | Savings     | 1000   |            | Test payment | Please fill out this field. |
      | Wells Fargo     | Savings     |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Wells Fargo     | Checking    | 1000   |            | Test payment | Please fill out this field. |
      | Wells Fargo     | Checking    |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Wells Fargo     | Loan        | 1000   |            | Test payment | Please fill out this field. |
      | Wells Fargo     | Loan        |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Wells Fargo     | Credit Card | 1000   |            | Test payment | Please fill out this field. |
      | Wells Fargo     | Credit Card |        | 2020-05-10 | Test payment | Please fill out this field. |
      | Wells Fargo     | Brokerage   | 1000   |            | Test payment | Please fill out this field. |
      | Wells Fargo     | Brokerage   |        | 2020-05-10 | Test payment | Please fill out this field. |


