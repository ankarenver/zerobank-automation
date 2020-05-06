package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OnlineStatementsPage {

    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    private int year;

    public OnlineStatementsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void selectRecentStatementYear(Integer year){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(""+year)));
        Driver.getDriver().findElement(By.linkText(""+year)).click();
        this.year = year;
    }

    public Integer getCountStatement(){
        List<WebElement> statements = Driver.getDriver().findElements(By.xpath("//div[@id='os_"+year+"']//table[@class='table table-bordered']//td[1]"));
        return statements.size();
    }


    public void clickOnStatements(){
        List<WebElement> statements = Driver.getDriver().findElements(By.xpath("//div[@id='os_"+year+"']//table[@class='table table-bordered']//td[1]//a"));
        statements.forEach(each-> each.click());
//        BrowserUtils.wait(3);
    }

    public boolean isDownloadFileContain(String nameOfFile){
        File file = new File("C:\\Users\\Msi\\Downloads\\");
        File[] allFilesInDownloadFolder = file.listFiles();
        List<String> nameOfTheFiles = new ArrayList<>();
        for (File each : allFilesInDownloadFolder){
            nameOfTheFiles.add(each.getName());
        }
        System.out.println(nameOfTheFiles);
        for (String each : nameOfTheFiles){
            if (each.contains(nameOfFile)){
                return true;
            }
        }
        return false;
    }

    public boolean isFileTypePDF(){
        File file = new File("C:\\Users\\Msi\\Downloads\\");
        File[] allFilesInDownloadFolder = file.listFiles();
        List<String> nameOfTheFiles = new ArrayList<>();
        for (File each : allFilesInDownloadFolder){
            nameOfTheFiles.add(each.getName());
        }
        System.out.println(nameOfTheFiles);
        for (String each : nameOfTheFiles){
            if (each.contains(".pdf")){
                return true;
            }
        }
        return false;

    }



}
