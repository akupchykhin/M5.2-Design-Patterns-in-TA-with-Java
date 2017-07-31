package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
	private static WebDriver driver;

	public WebDriverSingleton(WebDriver webDriverInstance) {
	}

	public static WebDriver getWebDriverInstance() {
		if (driver == null) {
        	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			driver = new ChromeDriver(capabilities);
			driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void kill() {
		if (driver != null) {
			try {
				System.out.println("Browser will be closed now...");
				driver.quit();
			} catch (Exception e) {
			} finally {
				driver = null;
			}
		}
	}
}
