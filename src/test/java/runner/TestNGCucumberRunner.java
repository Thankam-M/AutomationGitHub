package runner;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src/test/features"},
        glue = {"Stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber-report.json"},
        tags = "@smoke"
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
    public TestNGCucumberRunner() {
    }

    @Test
    public void runCucumberTests() {
    }
}
