package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinitions {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Then("account dropdown default option must be {string}")
    public void account_dropdown_default_option_must_be(String defaultOption) {
        System.out.println("verify that default options of dropdown is " + defaultOption);
        Assert.assertEquals(defaultOption,accountActivityPage.getAccountDefaultSelection());
    }

    @Then("account dropdown should have following options:")
    public void account_dropdown_should_have_following_options(List<String> dataTable) {
        System.out.println("verifying dropdown options");
        Assert.assertEquals(dataTable,accountActivityPage.getListOfAccountSelection());
    }

    @Then("transactions table should have column names as follow:")
    public void transactions_table_should_have_column_names_as_follow(List<String> dataTable) {
        System.out.println("verifying column names");
        Assert.assertEquals(dataTable,accountActivityPage.getTransactionColumnNames());
    }

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        accountActivityPage.clickOnFindTransactionBtn();
    }


    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        accountActivityPage.setDescription(string);
    }

    @When("clicks search")
    public void clicks_search() {
        accountActivityPage.clickOnFindBtn();
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        Assert.assertTrue(accountActivityPage.checkDescriptionContainsValue(string));
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        Assert.assertFalse(accountActivityPage.checkDescriptionContainsValue(string));
    }


    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) {
        accountActivityPage.setDateFromTo(from,to);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) {
        Assert.assertTrue(accountActivityPage.isResultBetween(from,to));
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        Assert.assertTrue(accountActivityPage.isValuesSorted());
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        Assert.assertFalse(accountActivityPage.isContainValue(string));
    }



}
