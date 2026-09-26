package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginPage extends BasePage {

    // Locators
    private final By changeLanguageToEnglish = AppiumBy.xpath("//android.widget.TextView[@text='EN']");
    private final By skipBtn = AppiumBy.xpath("//android.widget.TextView[@text='Skip']");
    private final By phoneNumber = AppiumBy.className("android.widget.EditText");
    private final By phoneIcon = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    private final By nextBtn = AppiumBy.accessibilityId("Next");
    private final By password = AppiumBy.xpath("//android.widget.EditText[@text='Enter your password']");
    private final By loginBtn = AppiumBy.accessibilityId("Login");

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public LoginPage resetAppToBackground() {
        ((AndroidDriver) driver.getDriver()).runAppInBackground(Duration.ofSeconds(5));
        return this;
    }

    public LoginPage selectEnglishLanguageAndSkip() {
        driver.element().click(changeLanguageToEnglish);
        driver.element().click(skipBtn);
        return this;
    }

    public HomePage login(String phone, String pass) {
        driver.element().type(phoneNumber, phone);
        driver.element().click(phoneIcon);
        driver.element().click(nextBtn);
        driver.element().type(password, pass);
        driver.element().click(loginBtn);
        return new HomePage(driver);
    }
}