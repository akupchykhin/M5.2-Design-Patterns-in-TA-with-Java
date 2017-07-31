package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.WebDriverSingleton;

public class InboxPage extends AbstractPage {

    private static final By LOGOFF_SELECTOR_LOCATOR = By.xpath("//div[@class='mail-User-Name']");
    private static final By LOGOFF_BUTTON_LOCATOR = By.xpath("//a[@data-metric='Меню сервисов:Выход']");

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public static HomePage logoff() {
        WebDriverSingleton.getWebDriverInstance().findElement(LOGOFF_SELECTOR_LOCATOR).click();
        WebDriverWait waitForLogoffButton = new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), 2);
        waitForLogoffButton.until(ExpectedConditions.elementToBeClickable(LOGOFF_BUTTON_LOCATOR)).click();
        return new HomePage(WebDriverSingleton.getWebDriverInstance());
    }
}
