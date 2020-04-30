package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

}
