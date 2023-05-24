package manage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class ConfigurationWiki {
    protected  static AppiumDriver<MobileElement> driver;
    protected Logger logger = LoggerFactory.getLogger(ConfigurationWiki.class);

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "qa_new");
        capabilities.setCapability("platformVersion","8.1");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivities", ".main.MainActivity");

        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app","C:/Users/pv297/Downloads/test/install/wiki.apk");
        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AppiumListener());


    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}