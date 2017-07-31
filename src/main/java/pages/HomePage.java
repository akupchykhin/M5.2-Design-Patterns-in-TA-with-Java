package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.utils.WebDriverSingleton;

public class HomePage extends AbstractPage {

    public static final By HOME_LOGO_LOCATOR = By.cssSelector(".home-logo__default");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static HomePage userOnHomePageVerify() {
        waitForElementPresent(HOME_LOGO_LOCATOR);
        return new HomePage(WebDriverSingleton.getWebDriverInstance());
    }
}
