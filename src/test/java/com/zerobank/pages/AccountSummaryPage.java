package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage {

    @FindBy(tagName = "h2")
    private List<WebElement> accountType;

    @FindBy(xpath = "//h2[text()='Credit Accounts']/following-sibling::div[1]//th")
    private List<WebElement> columnNamesOfCreditAccount;


    public AccountSummaryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public List<String> getAccountsName(){
        return BrowserUtils.getTextFromWebElement(accountType);
    }

    public List<String> getColumnsInCreditAccount(){
        return BrowserUtils.getTextFromWebElement(columnNamesOfCreditAccount);
    }

    public void clickOnLinksUnderAccount(String string){
        Driver.getDriver().findElement(By.linkText(string)).click();
    }
}
