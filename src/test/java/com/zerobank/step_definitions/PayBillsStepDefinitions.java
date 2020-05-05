package com.zerobank.step_definitions;


import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class PayBillsStepDefinitions {

    PayBillsPage payBillsPage = new PayBillsPage();

    private String dateOrAmount="";

    @Then("make pay with following info:")
    public void make_pay_with_following_info(List<Map<String,String>> dataTable) {
        for (Map<String,String> row :dataTable){
            payBillsPage.setPayee(row.get("Payee"));
            payBillsPage.setAccount(row.get("Account"));
            payBillsPage.setAmount(row.get("Amount"));
            payBillsPage.setDate(row.get("Date"));
            payBillsPage.setDescription(row.get("Description"));
            Assert.assertTrue(payBillsPage.isPopUpMsgDisplayed());
            Assert.assertEquals(row.get("Verify"),payBillsPage.getPopUpMsg());
        }
    }



    @Then("can not make pay with following info:")
    public void can_not_make_pay_with_following_info(List<Map<String,String>> dataTable) {

        if (dataTable.get(0).get("Amount")==null){
            dateOrAmount="Amount";
        }
        if (dataTable.get(0).get("Date")==null){
            dateOrAmount="Date";
        }

        for (Map<String,String> row :dataTable){
            payBillsPage.setPayee(row.get("Payee"));
            payBillsPage.setAccount(row.get("Account"));
            payBillsPage.setAmount(row.get("Amount"));
            payBillsPage.setDate(row.get("Date"));
            payBillsPage.setDescription(row.get("Description"));
            BrowserUtils.wait(2);
            Assert.assertEquals(row.get("Verify"),payBillsPage.getPopUpAlert(dateOrAmount));
        }


    }

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        payBillsPage.navigateTo("Add New Payee");
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
        dataTable.keySet().forEach(each->payBillsPage.setDataFor(each,dataTable.get(each)));
        payBillsPage.clickOnAdd();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
        Assert.assertEquals(message,payBillsPage.getGreenMsg());
    }



    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        payBillsPage.navigateTo("Purchase Foreign Currency");
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        Assert.assertTrue(payBillsPage.areTheseCurrencyAvailable(dataTable));
    }


    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.clickOnCalculateCosts();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(payBillsPage.isAlertDisplayed());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        payBillsPage.selectCurrency();
        payBillsPage.clickOnCalculateCosts();
    }


}


