package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage {

    private  Select accounts = new Select(Driver.getDriver().findElement(By.id("aa_accountId")));

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    private List<WebElement> transactionColumnNames;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    private WebElement findTransactionsBtn;


    public AccountActivityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public List<String> getListOfAccountSelection(){
        return BrowserUtils.getTextFromWebElement(accounts.getOptions());
    }

    public String getAccountDefaultSelection(){
        return accounts.getFirstSelectedOption().getText();
    }

    public List<String> getTransactionColumnNames(){
        return BrowserUtils.getTextFromWebElement(transactionColumnNames);
    }

    public void clickOnFindTransactionBtn(){
        findTransactionsBtn.click();
    }







}