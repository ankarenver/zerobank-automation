package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("open login page");
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    }

    @When("user logs in as an authorized user")
    public void user_logs_in_as_an_authorized_user() {
        System.out.println("login as authorized user");
        loginPage.login();
    }

    @Then("user should be able to see account summary page title")
    public void user_should_be_able_to_see_account_summary_page_title() {
        System.out.println("verify the title");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Zero - Account Summary");
    }

    @When("user logs in as an not authorized user by using username {string} and password {string}")
    public void user_logs_in_as_an_not_authorized_user_by_using_username_and_password(String username, String password) {
        System.out.println("login with different credential");
        loginPage.login(username,password);
    }

    @Then("user should not be able to login")
    public void user_should_not_be_able_to_login() {
        System.out.println("invalid user should not be able to login that stuck in login page");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Zero - Log in");
    }

    @Then("user should be able to see error message as {string}")
    public void user_should_be_able_to_see_error_message_as(String errorMsg) {
        System.out.println("verifying the error message is display");
        Assert.assertEquals(errorMsg,loginPage.getError());
    }


}
