package com.zerobank.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/zerobank/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        strict = false,
        tags = "@pay_bill_un_successful_pay_operation",
        plugin = {"json:target/cucumber.json"

        }
)
public class CukesRunner {
}
