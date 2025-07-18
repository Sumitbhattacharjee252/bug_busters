package com.browserstack;

import io.cucumber.testng.*;

@CucumberOptions(
        glue = "com.browserstack.stepdefs",
        features = "src/test/resources/features/test",
//        tags = "@PLP",
        plugin = {
                "pretty",
                "html:reports/tests/cucumber/cucumber-pretty.html",
                "testng:reports/tests/cucumber/testng/cucumber.xml",
                "json:reports/tests/cucumber/json/cucumberTestReport.json"
        }
)
//comment Arsalan
public class RunWebDriverCucumberTests extends AbstractTestNGCucumberTests {}
