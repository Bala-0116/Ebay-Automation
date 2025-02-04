package testrunners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;



@Test
@CucumberOptions(
        features = "src/test/resources/Feature/ebay.feature",
        glue = "stepdefinitions",
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-html-report"
        }
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {


}
