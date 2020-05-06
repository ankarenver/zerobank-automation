package com.zerobank.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = "com/zerobank/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        strict = false,
        tags = "",
        plugin = {
                "json:target/cucumber.json",


        }
)
public class CukesRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel =  true)
        public  Object[][] scenarios(){
                return super.scenarios();
        }

}
