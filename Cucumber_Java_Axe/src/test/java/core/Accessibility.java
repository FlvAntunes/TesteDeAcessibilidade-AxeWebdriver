package core;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.junit.Assert;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.cucumber.java.Scenario;
import steps.BeforeAfter;

public class Accessibility {

	public void checkBestPractice() throws IOException, OperationNotSupportedException {
		Scenario scenario = BeforeAfter.getScenario();
		/**
		 * Tags disponiveis tags: wcag2a, wcag2aa, wcag21a, wcag21aa, section508,
		 * best-practice, experimental, cat.*
		 */
		List<String> expectedTags = Arrays.asList("best-practice");
		Results result = new AxeBuilder().withTags(expectedTags).analyze(DriverFactory.getDriver());
		List<Rule> violations = result.getViolations();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(violations);
		String jsonOutput2 = gson.toJson(result);

		AxeReporter.setAxeResultString(jsonOutput2);

		scenario.attach(jsonOutput, "application/json", "Resultado");

		Assert.assertEquals("violations found", 0, violations.size());

	}

	public void checkAll() throws IOException, OperationNotSupportedException {
		Scenario scenario = BeforeAfter.getScenario();
		Results result = new AxeBuilder().analyze(DriverFactory.getDriver());
		List<Rule> violations = result.getViolations();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(violations);

		scenario.attach(jsonOutput, "application/json", "Resultado");

		Assert.assertEquals("violations found", 0, violations.size());

	}

	public void checkWcag21aa() throws IOException, OperationNotSupportedException {
		Scenario scenario = BeforeAfter.getScenario();
		List<String> expectedTags = Arrays.asList("wcag21aa");

		Results result = new AxeBuilder().withTags(expectedTags).analyze(DriverFactory.getDriver());
		List<Rule> violations = result.getViolations();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(violations);
		String jsonOutput2 = gson.toJson(result);

		AxeReporter.setAxeResultString(jsonOutput2);

		scenario.attach(jsonOutput, "application/json", "Resultado");

		Assert.assertEquals("violations found", 0, violations.size());

	}

}
