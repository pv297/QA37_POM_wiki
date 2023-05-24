package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ModalLoginScreen extends BaseScreen {
    public ModalLoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/explore_overflow_account_name']")
    MobileElement loginButton;
    @FindBy (xpath = "//*[@resource-id='org.wikipedia:id/explore_overflow_log_out']")
    MobileElement logOutButton;
    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/explore_overflow_account_name']")
    MobileElement accountName;


    public LoginScreen cklickTheLoginButton() {
        loginButton.click();
        return new LoginScreen(driver);
    }

    public boolean isLogged() {
        return logOutButton.isDisplayed();
    }

    public String getInf() {
        return accountName.getText();
    }

    public String getInfOut() {
        return logOutButton.getText();
    }
    public MainScreen logOut(){
        should(logOutButton,40);
        logOutButton.click();
        return new MainScreen(driver);
    }

    public String getIngLog() {
        return accountName.getText();
    }
}