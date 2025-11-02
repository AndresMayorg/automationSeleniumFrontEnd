package co.orangehrm.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "co.orangehrm.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports/html", "json:target/cucumber-reports/cucumber.json"},
        tags = "@SuccessfulEmployeeCreation",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
)
public class TestRunner {
}
