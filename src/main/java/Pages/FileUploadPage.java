package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class FileUploadPage extends BasePage {

    // Locators
    private final By browseCardBtn = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='Browse'])[1]");
    private final By browseBtn = AppiumBy.accessibilityId("Browse");
    private final By selectFile = AppiumBy.accessibilityId("Files");
    private final By uploadedFile = By.xpath("//*[@text='Attachment.png']");
    private final By submitPrescription = AppiumBy.accessibilityId("Submit");
    private final By selectInsuranceCompany = AppiumBy.accessibilityId("Select Insurance Company");
    private final By selectEgyCareInsuranceCompany = AppiumBy.accessibilityId("EGYCare");
    private final By phoneNumberInput = AppiumBy.className("android.widget.EditText");
    private final By note = AppiumBy.xpath("//android.widget.EditText[@text='Type your note']");

    public FileUploadPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public FileUploadPage selectInsuranceCompany() {
        driver.element().click(selectInsuranceCompany);
        driver.element().click(selectEgyCareInsuranceCompany);
        return this;
    }

    public FileUploadPage enterInsuranceNumber(String number) {
        driver.element().type(phoneNumberInput, number);
        return this;
    }

    public FileUploadPage uploadCardImage() {
        driver.element().click(browseCardBtn);
        driver.element().click(selectFile);
        driver.element().click(uploadedFile);
        return this;
    }

    public FileUploadPage uploadPrescriptionImage() {
        driver.element().click(browseBtn);
        driver.element().click(selectFile);
        driver.element().click(uploadedFile);
        return this;
    }

    public FileUploadPage scrollToNote() {
        driver.element().scrollToElement(note);
        return this;
    }

    public void clickSubmit() {
        driver.element().click(submitPrescription);
    }
}