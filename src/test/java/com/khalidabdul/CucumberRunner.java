package com.khalidabdul;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        junit = "--step-notifications",
        plugin = {"pretty", "json:target/cucumber.json"},
        features = "src/test/resources/features/",
        tags = {"@Regression"})
public class CucumberRunner {
}