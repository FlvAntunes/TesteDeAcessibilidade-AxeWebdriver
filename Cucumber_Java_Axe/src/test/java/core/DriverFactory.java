package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

//	private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	public static WebDriver initDriver() {
		WebDriver driver = null;

		switch (Propriedades.browser) {
		case FIREFOX:
			System.setProperty("webdriver.firefox.driver", "src/test/java/Drivers/geckodriver.exe");
			FirefoxOptions options1 = new FirefoxOptions();
			options1.setHeadless(true); options1.addArguments("window-size=1600x900");// execução sem abrir o navegador
			//driver.manage().window().maximize();
			driver = new FirefoxDriver(options1);
		
		
			break;

		case CHROME:
			System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
			ChromeOptions options2 = new ChromeOptions();
//			options2.addArguments("start-maximized");
			options2.addArguments("window-size=1600x900");options2.addArguments("headless");// execução sem abrir o navegador
			driver = new ChromeDriver(options2);
			break;
		}
		// driver.manage().window().setSize(new Dimension(1600, 900));

		return driver;
	}

	public static void killDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		if (threadDriver != null) {
			threadDriver.remove();
		}
	}
}
