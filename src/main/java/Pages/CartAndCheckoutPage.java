package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CartAndCheckoutPage extends BasePage {

    // Locators
    private final By checkoutBtn = AppiumBy.accessibilityId("Checkout");
    private final By abbassiaBranch = AppiumBy.accessibilityId("Cairo Scan-Egypt (Scans/Labs) - Abbasiya");
    private final By selectMaadiBranch = AppiumBy.accessibilityId("Cairo Scan-Egypt (Scans/Labs) - Maadi - El Gazaier St");
    private final By nextBtn = AppiumBy.accessibilityId("Next");
    private final By selectPaymentMethod = AppiumBy.accessibilityId("Select Payment Method");
    private final By selectOnlinePayment = AppiumBy.accessibilityId("Online Payment");
    private final By addPartialAmount = AppiumBy.accessibilityId("0");
    private final By payAmountScan = AppiumBy.accessibilityId("Pay ( 249.00 EGP )");
    private final By payAmountSdd = AppiumBy.accessibilityId("Pay ( 300.00 EGP )");

    public CartAndCheckoutPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public CartAndCheckoutPage clickCheckout() {
        driver.element().click(checkoutBtn);
        return this;
    }

    public CartAndCheckoutPage selectScanBranches() {
        driver.element().click(abbassiaBranch);
        driver.element().click(selectMaadiBranch);
        return this;
    }

    public CartAndCheckoutPage clickNext() {
        driver.element().click(nextBtn);
        return this;
    }

    public CartAndCheckoutPage selectOnlinePaymentMethod() {
        driver.element().click(selectPaymentMethod);
        driver.element().click(selectOnlinePayment);
        return this;
    }

    public CartAndCheckoutPage enterPartialAmount(String amount) {
        driver.element().type(addPartialAmount, amount);
        return this;
    }

    public void clickPayScan() {
        driver.element().click(payAmountScan);
    }

    public void clickPaySdd() {
        driver.element().click(payAmountSdd);
    }
}