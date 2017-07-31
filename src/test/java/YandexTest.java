import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.business_objects.Letter;
import pages.business_objects.User;
import pages.services.LetterFactory;
import pages.services.LetterService;
import pages.services.UserFactory;
import pages.services.UserService;
import pages.utils.WebDriverSingleton;

public class YandexTest {

    @BeforeMethod(description = "Start browser")
     public void browserStart() {
        WebDriverSingleton.getWebDriverInstance();
    }

    @BeforeMethod
    public void login() {
        User user = new UserFactory().createUser();
        UserService.login(user);
    }

    @AfterMethod
    public void driverClose() {
        WebDriverSingleton.kill();
    }

    @Test(description = "Create a new mail and save it as draft")
    public void newMailCreation() {
        Letter letter = new LetterFactory().createLetter();
        LetterService.newEmailCreation(letter);
        ScreenshotsMaker.makeScreenshot();
        WebElement emailWasCreated = WebDriverSingleton.getWebDriverInstance().findElement(ComposePage.AUTOSAVE_STATUS_LOCATOR);
        Assert.assertTrue(emailWasCreated.isDisplayed(), "Email was not created");
    }

    @Test(description = "Verify, that the mail presents in ‘Drafts’ folder")
    public void emailInDraftVerify() {
        Letter letter = new LetterFactory().createLetter();
        LetterService.newEmailCreation(letter);
        DraftsPage.draftUrl().findAnEmailInDraftFolder();
        String emailInDraft = WebDriverSingleton.getWebDriverInstance().findElement(DraftsPage.BUBBLE_BLOCK_TEXT_LOCATOR).getText();
        Assert.assertEquals(emailInDraft, DraftsPage.RECEIVER, "Email not in Drafts folder");
        ScreenshotsMaker.makeScreenshot();
    }

    @Test(description = "Send the mail")
    public void sendTheEmail() {
        Letter letter = new LetterFactory().createLetter();
        LetterService.newEmailCreation(letter);
        LetterService.sendTheEmail();
        WebElement emaisWasSent = WebDriverSingleton.getWebDriverInstance().findElement(ComposePage.SENT_NOTIFICATION_LOCATOR);
        Assert.assertTrue(emaisWasSent.isDisplayed(), "Email was not sent");
        ScreenshotsMaker.makeScreenshot();
    }

    @Test(description = "Verify, that the mail is in ‘Sent’ folder.")
    public void emailIsInSent() {
        Letter letter = new LetterFactory().createLetter();
        LetterService.newEmailCreation(letter);
        LetterService.sendTheEmail();
        SentPage.goToSentPage().verifyThatEmailIsInSentFolder();
        String emailIsInSent = WebDriverSingleton.getWebDriverInstance().findElement(SentPage.RECEIVER_NAME).getText();
        Assert.assertEquals(emailIsInSent, SentPage.RECEIVER, "Email not in Sent folder");
        ScreenshotsMaker.makeScreenshot();
    }

    @Test(description = "Log off")
    public void logOff() {
        InboxPage.logoff();
        HomePage.userOnHomePageVerify();
        WebElement userLoggedOut = WebDriverSingleton.getWebDriverInstance().findElement(HomePage.HOME_LOGO_LOCATOR);
        Assert.assertTrue(userLoggedOut.isDisplayed(), "User can not log out");
        ScreenshotsMaker.makeScreenshot();
    }
}