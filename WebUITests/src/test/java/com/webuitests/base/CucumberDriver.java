package com.webuitests.base;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)

@CucumberOptions(glue="com/webuitests/cuketests",monochrome = false,features = "src/test/resources/features", plugin = {"pretty","html:target/cucumber-html-report","json:target/cucumber.json"}, tags ={"@Validate_Section_Of_Dash_Board"})

public class CucumberDriver {
}