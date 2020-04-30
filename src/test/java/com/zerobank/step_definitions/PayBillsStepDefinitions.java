package com.zerobank.step_definitions;


import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
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
}
