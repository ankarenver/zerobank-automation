package com.zerobank.step_definitions;


import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before
    public void setup(){
        System.out.println("before scenario");
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void teardown(Scenario scenario){
        // how to check if scenario is failed
        if (scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            // attach screenshot to the report
            scenario.embed(image,"image/png",scenario.getName());
        }
        Driver.closeDriver();
        System.out.println("after scenario");
    }
}
