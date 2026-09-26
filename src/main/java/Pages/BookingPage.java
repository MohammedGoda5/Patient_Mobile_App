package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class BookingPage extends BasePage {

    // Service Type Locators
    private final By selectLabHome = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Lab, Home Visit']/android.view.ViewGroup[3]");
    private final By selectLabBranch = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Lab, Branch Visit']/android.view.ViewGroup[3]");
    private final By selectScanHome = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Scan, Home Visit']/android.view.ViewGroup[3]");
    private final By selectScanBranch = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Scan, Branch Visit']/android.view.ViewGroup[2]");

    // Category Locators
    private final By selectBrowseProcedure = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Continue'])[1]");
    private final By selectNonInsurancePrescription = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Continue'])[2]");
    private final By selectInsurancePrescription = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Continue'])[3]");
    private final By selectLabInsurancePrescription = AppiumBy.accessibilityId("Continue");

    // Items / Modalities Locators
    private final By selectXrayModality = AppiumBy.accessibilityId("X-ray (DR/CR), X-ray (DR/CR), 3 Procedures");
    private final By selectXrayModalityHome = AppiumBy.accessibilityId("X-ray (DR/CR), X-ray (DR/CR), 4 Procedures");
    private final By selectLabModality = AppiumBy.xpath("(//android.widget.TextView[@text='LAB'])[1]");
    private final By addMriArmToCart = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]");
    private final By addSddToCart = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]");
    private final By cartIcon = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='1']/android.view.ViewGroup[1]/com.horcrux.svg.SvgView");

    public BookingPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public BookingPage selectScanBranch() {
        driver.element().click(selectScanBranch);
        return this;
    }

    public BookingPage selectScanHome() {
        driver.element().click(selectScanHome);
        return this;
    }

    public BookingPage selectLabHome() {
        driver.element().click(selectLabHome);
        return this;
    }

    public BookingPage selectLabBranch() {
        driver.element().click(selectLabBranch);
        return this;
    }

    public BookingPage selectBrowseProcedure() {
        driver.element().click(selectBrowseProcedure);
        return this;
    }

    public FileUploadPage selectNonInsurancePrescription() {
        driver.element().click(selectNonInsurancePrescription);
        return new FileUploadPage(driver);
    }

    public FileUploadPage selectInsurancePrescription() {
        driver.element().click(selectInsurancePrescription);
        return new FileUploadPage(driver);
    }

    public FileUploadPage selectLabInsurancePrescription() {
        driver.element().click(selectLabInsurancePrescription);
        return new FileUploadPage(driver);
    }

    public BookingPage selectXrayModalityBranch() {
        driver.element().click(selectXrayModality);
        return this;
    }

    public BookingPage selectXrayModalityHome() {
        driver.element().click(selectXrayModalityHome);
        return this;
    }

    public BookingPage selectLabModality() {
        driver.element().click(selectLabModality);
        return this;
    }

    public BookingPage addMriArmToCart() {
        driver.element().click(addMriArmToCart);
        return this;
    }

    public BookingPage addSddToCart() {
        driver.element().click(addSddToCart);
        return this;
    }

    public CartAndCheckoutPage openCart() {
        driver.element().click(cartIcon);
        return new CartAndCheckoutPage(driver);
    }
}