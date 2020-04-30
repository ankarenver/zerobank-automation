package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefinitions {

    LoginPage loginPage = new LoginPage();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @When("user navigate to {string} page")
    public void user_navigate_to_page(String moduleName) {
        System.out.printf("navigate to %s page\n",moduleName);
        loginPage.navigateTo(moduleName);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        System.out.println("verify the title as " + title);
        Assert.assertEquals(title, Driver.getDriver().getTitle());
    }

    @Then("user should see following account types:")
    public void user_should_see_following_account_types(List<String> accountTypes) {
        System.out.println("verify account types");
        Assert.assertEquals(accountTypes,accountSummaryPage.getAccountsName());
    }

    @Then("credit accounts table must have following columns:")
    public void credit_accounts_table_must_have_following_columns(List<String> columns) {
        System.out.println("verify columns ");
        Assert.assertEquals(columns,accountSummaryPage.getColumnsInCreditAccount());
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String nameOfLink) {
        accountSummaryPage.clickOnLinksUnderAccount(nameOfLink);
        BrowserUtils.wait(3);
    }
}
