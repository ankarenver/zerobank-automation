package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "signin_button")
    private WebElement firstSignInBtn;

    @FindBy(id = "user_login")
    private WebElement userName;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(css = "div[class='alert alert-error']")
    private WebElement errorMessage;


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    /**
     * This method login as a authorized user
     */
    public void login(){
        BrowserUtils.waitForPageToLoad(10);
        firstSignInBtn.click();
        userName.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }

    public void login(String username, String password){
        BrowserUtils.waitForPageToLoad(10);
        firstSignInBtn.click();
        this.userName.sendKeys(username);
        this.password.sendKeys(password,Keys.ENTER);
    }

    public String getError(){
        return errorMessage.getText();
    }

    public void navigateTo(String moduleName){
        BrowserUtils.waitForPageToLoad(10);
        Driver.getDriver().findElement(By.linkText(moduleName)).click();
    }
}
