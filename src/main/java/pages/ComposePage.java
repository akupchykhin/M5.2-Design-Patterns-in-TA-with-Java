package pages;

import org.openqa.selenium.By;

public class ComposePage {

    public static final By TO_FIELD_LOCATOR = By.cssSelector(".js-compose-field.mail-Bubbles");
    public static final By SUBJECT_FIELD_LOCATOR = By.cssSelector(".mail-Compose-Field-Input-Controller.js-compose-field.js-editor-tabfocus-prev");
    public static final By MESSAGE_BODY_FIELD_LOCATOR = By.xpath(".//*[@id='cke_1_contents']/div");
    public static final By AUTOSAVE_STATUS_LOCATOR = By.xpath("//span[@data-key='view=compose-autosave-status']");
    public static final By RESIZE_FIELD_ELEMENT_LOCATOR = By.cssSelector("#cke_1_resizer");
    public static final By DEFAULT_FIELD_FOR_SENDING_LOCATOR = By.xpath("//div[@role='textbox']");
    public static final By SENT_NOTIFICATION_LOCATOR = By.className(" js-mail-Notification-Content");
    public static final By COMPOSE_BUTTON_LOCATOR = By.cssSelector(".mail-ComposeButton-Text");
}
