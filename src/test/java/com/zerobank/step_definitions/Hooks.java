package com.zerobank.step_definitions;


import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void setup(){
        System.out.println("before scenario");
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void teardown(){
        Driver.closeDriver();
        System.out.println("after scenario");
    }
}
