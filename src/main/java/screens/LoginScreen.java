package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.User;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen {
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/login_username_text']")
    MobileElement userName;
    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/login_password_input']")
    MobileElement password;
    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/login_button']")
    MobileElement logButton;


    public MainScreen fillInLoginForm(User user) {
        type(userName, user.getUserName());
        should(userName, 40);
        password.click();
        Actions action = new Actions(driver);
        action.sendKeys(user.getPassword()).perform();
        should(logButton,40);
        logButton.click();
        return new MainScreen(driver);
    }
}
