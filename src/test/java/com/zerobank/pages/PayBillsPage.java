package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayBillsPage {

    private  Select payee = new Select(Driver.getDriver().findElement(By.id("sp_payee")));

    private  Select account = new Select(Driver.getDriver().findElement(By.id("sp_account")));

    @FindBy(id = "sp_amount")
    private WebElement amount;

    @FindBy(id = "sp_date")
    private WebElement date;

    @FindBy(id = "sp_description")
    private WebElement description;

    @FindBy(css = "div[id='alert_content']")
    private WebElement popUpMsg;

    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);


    public PayBillsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void navigateTo(String moduleName){
        Driver.getDriver().findElement(By.linkText(moduleName)).click();
        BrowserUtils.waitForPageToLoad(10);
    }

    public void setPayee(String string){
        payee.selectByVisibleText(string);
    }

    public void setAccount(String string){ account.selectByVisibleText(string); }

    public void setAmount(String string){
        if (string==null){
            string="";
        }
        amount.sendKeys(string); }

    public void setDate(String string){
        if (string==null){
            string="";
        }
        date.sendKeys(string);
    }

    public void setDescription(String string){
        description.sendKeys(string, Keys.ENTER);
    }

    public String getPopUpMsg(){ return popUpMsg.getText(); }

    public boolean isPopUpMsgDisplayed(){return popUpMsg.isDisplayed();}

    /**
     *  i will figure out later
     * @return
     */
    public String getPopUpAlert(String string){
        if (string.equals("Date")){
            return date.getAttribute("validationMessage");
        }else if (string.equals("Amount")){
            return amount.getAttribute("validationMessage");
        }else {
            return null;
        }
    }


    public String getGreenMsg(){
        return Driver.getDriver().findElement(By.id("alert_content")).getText();
    }

    public void setDataFor(String tabName, String value){
        if (!tabName.contains("Payee")){
            tabName = "Payee "+tabName;
        }
        tabName = tabName.toLowerCase().replace(" ","_");
        System.out.println(tabName);
        System.out.println(value);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("np_new_"+tabName)));
        Driver.getDriver().findElement(By.id("np_new_"+tabName)).sendKeys(value);
    }

    public void clickOnAdd(){
        Driver.getDriver().findElement(By.id("add_new_payee")).click();
    }
}
