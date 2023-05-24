package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class MainScreen extends BaseScreen {
    public MainScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/view_card_header_title']")
    MobileElement detailView;
    @FindBy(xpath = "//*[@class = 'android.widget.TextView']")
    MobileElement searchField;
    @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/menu_overflow_button']")
    MobileElement flowButton;


    public String getDetail() {
        return detailView.getText();
    }

    public SearchScreen clickTheSearch() {
        searchField.click();
        return new SearchScreen(driver);
    }

    public ModalLoginScreen clickTheFlowButton() {
        should(flowButton,40);
        flowButton.click();
        return new ModalLoginScreen(driver);
    }
}