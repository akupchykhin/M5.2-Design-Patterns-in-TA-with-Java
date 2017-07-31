package pages.services;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.ComposePage;
import pages.business_objects.Letter;
import pages.utils.WebDriverSingleton;

public class LetterService extends AbstractPage {

    public LetterService(WebDriver webDriverInstance) {
        super(webDriverInstance);
    }

    public static void newEmailCreation(Letter letter) {
        waitForElementEnabled(ComposePage.COMPOSE_BUTTON_LOCATOR);
        highlightElement(ComposePage.COMPOSE_BUTTON_LOCATOR);
        WebDriverSingleton.getWebDriverInstance().findElement(ComposePage.COMPOSE_BUTTON_LOCATOR).click();
        WebDriverSingleton.getWebDriverInstance().findElement(ComposePage.TO_FIELD_LOCATOR).sendKeys(letter.getAddress());
        WebDriverSingleton.getWebDriverInstance().findElement(ComposePage.SUBJECT_FIELD_LOCATOR).sendKeys(letter.getSubject());
        WebDriverSingleton.getWebDriverInstance().findElement(ComposePage.MESSAGE_BODY_FIELD_LOCATOR).sendKeys(letter.getBody());
        String saveButton = Keys.chord(Keys.CONTROL, "s");
        WebDriverSingleton.getWebDriverInstance().findElement(ComposePage.MESSAGE_BODY_FIELD_LOCATOR).sendKeys(saveButton);
        WebDriverWait waitForAutosaveStatusElement = new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), 12);
        waitForAutosaveStatusElement.until(ExpectedConditions.visibilityOfElementLocated(ComposePage.AUTOSAVE_STATUS_LOCATOR));
        waitForElementVisible(ComposePage.AUTOSAVE_STATUS_LOCATOR);
        waitForElementVisible(ComposePage.RESIZE_FIELD_ELEMENT_LOCATOR);
        WebElement resize = WebDriverSingleton.getWebDriverInstance().findElement(ComposePage.RESIZE_FIELD_ELEMENT_LOCATOR);
        new Actions(WebDriverSingleton.getWebDriverInstance()).clickAndHold(resize).moveByOffset(150, -1500).release().build().perform();
    }

    public static LetterService sendTheEmail() {
        waitForElementEnabled(ComposePage.DEFAULT_FIELD_FOR_SENDING_LOCATOR);
        WebElement sendSaveButtons = WebDriverSingleton.getWebDriverInstance().findElement(ComposePage.DEFAULT_FIELD_FOR_SENDING_LOCATOR);
        new Actions(WebDriverSingleton.getWebDriverInstance()).sendKeys(sendSaveButtons,Keys.CONTROL, Keys.ENTER).build().perform();
        WebDriverWait waitForSentNotificationElement = new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), 5);
        waitForSentNotificationElement.until(ExpectedConditions.visibilityOfElementLocated(ComposePage.SENT_NOTIFICATION_LOCATOR));
        return new LetterService(WebDriverSingleton.getWebDriverInstance());
    }
}
