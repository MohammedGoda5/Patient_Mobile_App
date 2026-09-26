package testPackage;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.FileUploadUtils;

import java.time.Duration;

public class BaseTest {

    protected SHAFT.GUI.WebDriver driver;
    protected SHAFT.TestData.JSON testData;

    // Common App Locators
    protected By Change_Language_To_English = AppiumBy.xpath("//android.widget.TextView[@text='EN']");
    protected By Skip_Btn = AppiumBy.xpath("//android.widget.TextView[@text='Skip']");

    // Login Page Locators
    protected By Phone_Number = AppiumBy.className("android.widget.EditText");
    protected By Phone_Icon = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    protected By Next_Btn = AppiumBy.accessibilityId("Next");
    protected By Password = AppiumBy.xpath("//android.widget.EditText[@text='Enter your password']");
    protected By Login_Btn = AppiumBy.accessibilityId("Login");

    // Home Page Locators
    protected By Book_Appointment = AppiumBy.accessibilityId("Book Appointment");

    // Common Booking Locators
    protected By Select_Brwose_Procedure = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Continue'])[1]");
    protected By Select_Non_Insurance_Prescription = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Continue'])[2]");
    protected By Select_Insurance_Prescription = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Continue'])[3]");

    // File Upload / Attachment Locators
    protected By Browse_Card_Btn = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Browse'])[1]");
    protected By Browse_Btn = AppiumBy.accessibilityId("Browse");
    protected By Select_File = AppiumBy.accessibilityId("Files");
    protected By uploadedFile = By.xpath("//*[@text='Attachment.png']");
    protected By Submit_prescription = AppiumBy.accessibilityId("Submit");
    protected By Select_Insurance_Company = AppiumBy.accessibilityId("Select Insurance Company");
    protected By Select_EGYCare_Insurance_Company = AppiumBy.accessibilityId("EGYCare");
    protected By Note = AppiumBy.xpath("//android.widget.EditText[@text='Type your note']");

    // Common Cart & Payment Locators
    protected By Cart_Icon = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='1']/android.view.ViewGroup[1]/com.horcrux.svg.SvgView");
    protected By Checkout_Btn = AppiumBy.accessibilityId("Checkout");
    protected By Select_Payment_Method = AppiumBy.accessibilityId("Select Payment Method");
    protected By Select_Online_Payment = AppiumBy.accessibilityId("Online Payment");
    protected By Add_Partial_Amount = AppiumBy.accessibilityId("0");

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("simpleJSON.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Performs standard app initialization and user login using JSON test data.
     */
    protected void performLogin() {
        ((AndroidDriver) driver.getDriver()).runAppInBackground(Duration.ofSeconds(5));

        driver.element().click(Change_Language_To_English);
        driver.element().click(Skip_Btn);

        driver.element().type(Phone_Number, testData.getTestData("credentials.validPhone"));
        driver.element().click(Phone_Icon);
        driver.element().click(Next_Btn);
        driver.element().type(Password, testData.getTestData("credentials.password"));
        driver.element().click(Login_Btn);

        driver.assertThat().element(Book_Appointment).exists();
    }

    /**
     * Pushes the standard test attachment to emulator storage using JSON file paths.
     */
    protected void uploadAttachmentToDevice() {
        FileUploadUtils.uploadFileToDevice(
                driver.getDriver(),
                testData.getTestData("fileData.localPath"),
                testData.getTestData("fileData.devicePath")
        );
    }
}