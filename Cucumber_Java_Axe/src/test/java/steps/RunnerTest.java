package steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "steps",
		plugin = {"pretty","json:target/report.json",},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		publish = false,
		dryRun = false
)

public class RunnerTest {

}
