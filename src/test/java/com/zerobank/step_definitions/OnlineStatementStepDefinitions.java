package com.zerobank.step_definitions;

import com.zerobank.pages.OnlineStatementsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class OnlineStatementStepDefinitions {

    OnlineStatementsPage onlineStatementsPage = new OnlineStatementsPage();

    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(Integer int1) {
        onlineStatementsPage.selectRecentStatementYear(int1);
    }

    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(Integer int1) {
        Assert.assertEquals(int1,onlineStatementsPage.getCountStatement());
    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String nameOfStatement) {
        onlineStatementsPage.clickOnStatements();
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String name) {
        Assert.assertTrue(onlineStatementsPage.isDownloadFileContain(name));
    }

    @Then("the file type should be pdf")
    public void the_file_type_should_be_pdf() {
        Assert.assertTrue(onlineStatementsPage.isFileTypePDF());
    }
}
