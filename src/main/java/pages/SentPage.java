package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.utils.WebDriverSingleton;

public class SentPage extends AbstractPage {

    private static final String SENT_PAGE_URL = "https://mail.yandex.by/?uid=512863941&login=yalogintest#sent";
    private static final By SENDED_ELEMENT_LOCATOR = By.cssSelector(".mail-MessageSnippet-Item.mail-MessageSnippet-Item_body.js-message-snippet-body");
    private static final By SENT_FOLDER_ELEMENT_LOCATOR = By.cssSelector(".b-mail-pager__label");
    public static final By RECEIVER_NAME = By.cssSelector(".mail-MessageSnippet-FromText");
    public static final String RECEIVER  = "test2.asd@yandex.ru";

    public SentPage(WebDriver driver) {
        super(driver);
    }

    public static SentPage goToSentPage() {
        WebDriverSingleton.getWebDriverInstance().get(SENT_PAGE_URL);
        WebElement sentFolderElement = WebDriverSingleton.getWebDriverInstance().findElement(SENT_FOLDER_ELEMENT_LOCATOR);
        Assert.assertTrue(sentFolderElement.isDisplayed(), "Cannot reach sent folder");
        return new SentPage(WebDriverSingleton.getWebDriverInstance());
    }

    public SentPage verifyThatEmailIsInSentFolder() {
        waitForElementEnabled(SENDED_ELEMENT_LOCATOR);
        WebDriverSingleton.getWebDriverInstance().findElement(SENDED_ELEMENT_LOCATOR).click();
        return this;
    }
}
