package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);


    private  Select accounts = new Select(Driver.getDriver().findElement(By.id("aa_accountId")));

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    private List<WebElement> transactionColumnNames;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    private WebElement findTransactionsBtn;

    @FindBy(xpath = "//input[@id='aa_description']")
    private WebElement description;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement findBtn;

    @FindBy(xpath = "//h2[text()='Find Transactions']/following-sibling::div//td[2]")
    private List<WebElement> lisOfDescriptions;

    @FindBy(name = "fromDate")
    private WebElement dateFrom;

    @FindBy(id = "aa_toDate")
    private WebElement dateTo;

    @FindBy(xpath = "//h2[text()='Find Transactions']/following-sibling::div//td[1]")
    private List<WebElement> listOfDates;




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

    public void setDescription(String str){
        wait.until(ExpectedConditions.elementToBeClickable(description)).clear();
        description.sendKeys(str);
    }

    public void clickOnFindBtn(){
        BrowserUtils.wait(2);
        findBtn.click();
        BrowserUtils.wait(3);
    }

    public boolean checkDescriptionContainsValue(String value){
//         boolean isAllDescriptionsInStringContainsValue = true ;
//        List<String> descriptionsInString = BrowserUtils.getTextFromWebElement(lisOfDescriptions);
//        System.out.println(descriptionsInString);
//        for (String each :descriptionsInString){
//            if(!each.contains(value)){
//               return isAllDescriptionsInStringContainsValue= false;
//            }
//        }
//        return   isAllDescriptionsInStringContainsValue ;

        List<String> resultsInString = BrowserUtils.getTextFromWebElement(lisOfDescriptions);
        if (resultsInString.size()==0){
            return false;
        }
        for (String each : resultsInString){
            if (!each.contains(value)){
                return false;
            }
        }
        return true;
    }


    public void setDateFromTo(String from, String to){
        wait.until(ExpectedConditions.visibilityOf(dateFrom));
        if(!dateFrom.getAttribute("value").equals("")){
            wait.until(ExpectedConditions.elementToBeClickable(dateFrom)).clear();
        }
        if(!dateTo.getAttribute("value").equals("")){
            wait.until(ExpectedConditions.elementToBeClickable(dateTo)).clear();;
        }
        dateFrom.sendKeys(from);
        dateTo.sendKeys(to);
    }


    public boolean isResultBetween(String from, String to){
        LocalDate dateFrom = LocalDate.parse(from);
        LocalDate dateTo = LocalDate.parse(to);
        List<String> ListOfDatesInString = BrowserUtils.getTextFromWebElement(listOfDates);

        for (String each : ListOfDatesInString){
            LocalDate date = LocalDate.parse(each);
            if(!((dateFrom.isBefore(date)||dateFrom.isEqual(date))&&(dateTo.isAfter(date)||dateTo.isEqual(date)))){
                return false;
            }
        }
        return true;
    }


    public boolean isValuesSorted(){
        List<String> ListOfDatesInString = BrowserUtils.getTextFromWebElement(listOfDates);
        LocalDate temp = LocalDate.parse(ListOfDatesInString.get(0));
        for (String each : ListOfDatesInString){
            LocalDate toCompare = LocalDate.parse(each);

            if (temp.isBefore(toCompare)){
                return  false;
            }
            temp = toCompare;
        }
        return true;
    }


    public boolean isContainValue(String string){
        List<String> resultsInString = BrowserUtils.getTextFromWebElement(listOfDates);
        return resultsInString.contains(string);
    }



    public boolean isAtLeastOneValueContainInThisColumn(String columnName){
        List<String> columnNames = BrowserUtils.getTextFromWebElement(Driver.getDriver().findElements(By.xpath("//h2[text()='Find Transactions']/following-sibling::div//th")));
        int index=0;
        for (int i = 0; i <columnNames.size() ; i++) {
            if (columnNames.get(i).equalsIgnoreCase(columnName)){
                index=i+1;
            }
        }
        List<WebElement> allData = Driver.getDriver().findElements(By.xpath("//h2[text()='Find Transactions']/following-sibling::div//td["+index+"]"));
        List<String> allDataInString = BrowserUtils.getTextFromWebElement(allData);
//        System.out.println(allDataInString);
        for (String each : allDataInString){
            if (!each.equals("")){
                return true;
            }
        }
        return false;
    }


    public void setType(String string){
        Select type = new Select(Driver.getDriver().findElement(By.cssSelector("select[name='type']")));
        type.selectByVisibleText(string);
    }











}