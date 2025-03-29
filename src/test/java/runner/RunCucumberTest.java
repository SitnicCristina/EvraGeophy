package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.example.page.components.BaseComponent;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "StepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-report/cucumber-html-report.html",
        },
        tags = "@PreLogin",
        monochrome = true
)

public class RunCucumberTest{
}
