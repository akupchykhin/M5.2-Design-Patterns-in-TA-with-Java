package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.WebDriverSingleton;

public class AbstractPage {
    public static final int WAIT_FOR_TIMEOUT_SECONDS = 10;

    public AbstractPage(WebDriver webDriverInstance) {

    }

    public boolean isElementPresent(By locator) {
        return WebDriverSingleton.getWebDriverInstance().findElements(locator).size() > 0;
    }

    public static void waitForElementPresent(By locator) {
        new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), WAIT_FOR_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static void waitForElementVisible(By locator) {
        new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), WAIT_FOR_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementEnabled(By locator) {
        new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), WAIT_FOR_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void highlightElement(By locator) {
        ((JavascriptExecutor) WebDriverSingleton.getWebDriverInstance()).executeScript("arguments[0].style.border='3px solid green'", WebDriverSingleton.getWebDriverInstance().findElement(locator));
    }

    protected void unHighlightElement(By locator) {
        ((JavascriptExecutor) WebDriverSingleton.getWebDriverInstance()).executeScript("arguments[0].style.border='0px'", WebDriverSingleton.getWebDriverInstance().findElement(locator));
    }
}
