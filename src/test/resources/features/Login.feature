Feature: Login
  Only authorized users should be able to login to the application. When user logs in with valid credentials, Account summary page should be displayed.

  Background:
    Given user is on the login page

  @authorized_user_login
  Scenario: login as authorized user
    When user logs in as an authorized user
    Then user should be able to see account summary page title

    @not_authorized_user_login
  Scenario: login as un-authorized user
    When user logs in as an not authorized user by using username "username1" and password "password1"
    Then user should not be able to login
    Then user should be able to see error message as "Login and/or password are wrong."