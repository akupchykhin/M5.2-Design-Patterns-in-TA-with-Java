package pages.utils;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class DriverDecorator extends WebDriverSingleton {

	protected WebDriver driver;

	public DriverDecorator(WebDriver webDriverInstance) {
		super(webDriverInstance);
	}

	public void get(String url) {
		WebDriverSingleton.getWebDriverInstance().get(url);
	}

	public String getCurrentUrl() {
		return WebDriverSingleton.getWebDriverInstance().getCurrentUrl();
	}

	public String getTitle() {
		return WebDriverSingleton.getWebDriverInstance().getTitle();
	}

	public List<WebElement> findElements(By by) {
		return WebDriverSingleton.getWebDriverInstance().findElements(by);
	}

	public WebElement findElement(By by) {
		Reporter.log(String.format("Finding element: %s, current URL: '%s'", by.toString(), WebDriverSingleton.getWebDriverInstance().getCurrentUrl()),
				true);
		return WebDriverSingleton.getWebDriverInstance().findElement(by);
	}

	public String getPageSource() {
		return WebDriverSingleton.getWebDriverInstance().getPageSource();
	}

	public void close() {
		WebDriverSingleton.getWebDriverInstance().close();
	}

	public void quit() {
		System.out.println("Browser will be closed now...");
		WebDriverSingleton.getWebDriverInstance().quit();
	}

	public Set<String> getWindowHandles() {
		return WebDriverSingleton.getWebDriverInstance().getWindowHandles();
	}

	public String getWindowHandle() {
		return WebDriverSingleton.getWebDriverInstance().getWindowHandle();
	}

	public WebDriver.TargetLocator switchTo() {
		return WebDriverSingleton.getWebDriverInstance().switchTo();
	}

	public WebDriver.Navigation navigate() {
		return WebDriverSingleton.getWebDriverInstance().navigate();
	}

	public WebDriver.Options manage() {
		return WebDriverSingleton.getWebDriverInstance().manage();
	}
}
