package steps;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.Propriedades;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BeforeAfter {

	private static Scenario scenario;

	public static Scenario getScenario() {
		return scenario;
	}

	@Before
	public void before(Scenario scenario) {
		BeforeAfter.scenario = scenario;

	}
	
	/********* PÓS EXECUÇÃO ************/

	@After(order = 1)
	public void screenshot(Scenario cenario) throws URISyntaxException, IOException {

		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + cenario.getName().toString()
				+ "_" + System.currentTimeMillis() + ".jpeg"));
		InputStream screenshotStream = new FileInputStream(arquivo);
		cenario.attach(IOUtils.toByteArray(screenshotStream), "image/jpeg", "PrintScreen");
	}

	@After(order = 0)
	public void finaliza() {

		if (Propriedades.FECHAR_BROWSER) {
			killDriver();
		}

		System.out.println("Fechando Navegador");
		System.out.println("");
	}
	
}
