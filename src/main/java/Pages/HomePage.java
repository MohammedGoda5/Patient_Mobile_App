package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    // Locators
    private final By bookAppointment = AppiumBy.accessibilityId("Book Appointment");

    public HomePage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public HomePage verifyBookAppointmentVisible() {
        driver.assertThat().element(bookAppointment).exists();
        return this;
    }

    public BookingPage clickBookAppointment() {
        driver.element().click(bookAppointment);
        return new BookingPage(driver);
    }
}