package pages;


import org.openqa.selenium.By;

public class LoginPage {

    public static final By LOGIN_INPUT_FIELD_LOCATOR = By.xpath(".//*[@id='nb-1']/span/input");
    public static final By PASSWORD_INPUT_FIELD_LOCATOR = By.xpath(".//*[@id='nb-6']/span/input");
    public static final By LOGIN_BUTTON_LOCATOR = By.cssSelector(".nb-button._nb-action-button.nb-group-start");
}
