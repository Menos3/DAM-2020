package org.psg.m15.app.cucumber;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty", monochrome = false, strict = false,
        features = "src/test/resources/features", glue = "org.psg.m15.app")

public class PersonalitzacioRunner {
}
