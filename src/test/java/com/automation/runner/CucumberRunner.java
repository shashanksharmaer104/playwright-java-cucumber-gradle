package com.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.automation.stepdefs"},
        tags = "@Login",
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
        monochrome = true,
        publish = false)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void beforetest() {
        System.out.println("runner.CucumberRunner - code can be executed at the beginning the execution");
    }

    @AfterClass
    public void afterTest() {
        System.out.println("code can be executed at the end the execution");
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
