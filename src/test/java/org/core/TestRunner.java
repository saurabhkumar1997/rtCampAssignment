package org.Core;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/Features"},
        glue = "org.Steps",
        tags = "@smoke",
        plugin = {"pretty", "json:test-output/Cucumber.json","html:STDOUT","html:test-output/Cucumber.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    public TestRunner(){}
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){return super.scenarios();}
    @BeforeSuite
    public void BeforeSuite(){

    }
    @AfterSuite
    public void AfterSuite(){

    }
}
