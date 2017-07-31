package pages.services;

import org.openqa.selenium.WebDriver;
import pages.AbstractPage;
import pages.LoginPage;
import pages.business_objects.User;
import pages.utils.WebDriverSingleton;

public class UserService extends AbstractPage {

    public UserService(WebDriver webDriverInstance) {
        super(webDriverInstance);
    }

    public static void login(User user) {
        WebDriverSingleton.getWebDriverInstance().get(user.getEmailUrl());
        WebDriverSingleton.getWebDriverInstance().findElement(LoginPage.LOGIN_INPUT_FIELD_LOCATOR).sendKeys(user.getLogin());
        AbstractPage.highlightElement(LoginPage.LOGIN_BUTTON_LOCATOR);
        WebDriverSingleton.getWebDriverInstance().findElement(LoginPage.PASSWORD_INPUT_FIELD_LOCATOR).sendKeys(user.getPassword());
        WebDriverSingleton.getWebDriverInstance().findElement(LoginPage.LOGIN_BUTTON_LOCATOR).click();
    }
}
