package testPackage;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Scan_Tests extends BaseTest {

    // Scan Specific Locators
    private final By Select_Scan_Branch = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Scan, Branch Visit']/android.view.ViewGroup[2]");
    private final By Select_Scan_Home = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Scan, Home Visit']/android.view.ViewGroup[3]");
    private final By Select_Xray_Modality = AppiumBy.accessibilityId("X-ray (DR/CR), X-ray (DR/CR), 3 Procedures");
    private final By Select_Xray_Modality_Home = AppiumBy.accessibilityId("X-ray (DR/CR), X-ray (DR/CR), 4 Procedures");
    private final By add_Mri_Arm_To_Cart = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]");
    private final By Abbasia_Branch = AppiumBy.accessibilityId("Cairo Scan-Egypt (Scans/Labs) - Abbasiya");
    private final By Select_Maadi_Branch = AppiumBy.accessibilityId("Cairo Scan-Egypt (Scans/Labs) - Maadi - El Gazaier St");
    private final By Pay_Amount = AppiumBy.accessibilityId("Pay ( 249.00 EGP )");

    @Test(description = "Scan-Branch-Verify that the user can add M_P to cart then checkout and do partial payment.")
    public void Verify_User_Can_Book_Visit_Using_Browse_Procedure_Scan_Branch() {
        performLogin();

        driver.element().click(Book_Appointment);
        driver.element().click(Select_Scan_Branch);
        driver.element().click(Select_Brwose_Procedure);
        driver.element().click(Select_Xray_Modality);
        driver.element().click(add_Mri_Arm_To_Cart);
        driver.element().click(Cart_Icon);
        driver.element().click(Checkout_Btn);
        driver.element().click(Abbasia_Branch);
        driver.element().click(Select_Maadi_Branch);
        driver.element().click(Next_Btn);
        driver.element().click(Select_Payment_Method);
        driver.element().click(Select_Online_Payment);
        driver.element().type(Add_Partial_Amount, testData.getTestData("payment.scanBranchAmount"));
        driver.element().click(Pay_Amount);
    }

    @Test(description = "Scan-Branch-Verify that the user can Book using non insurance prescription")
    public void Book_Using_Non_Insurance_Prescription_Scan_Branch() {
        uploadAttachmentToDevice();
        performLogin();

        driver.element().click(Book_Appointment);
        driver.element().click(Select_Scan_Branch);
        driver.element().click(Select_Non_Insurance_Prescription);
        driver.element().click(Browse_Btn);
        driver.element().click(Select_File);
        driver.element().click(uploadedFile);
        driver.element().click(Submit_prescription);
    }

    @Test(description = "Scan-Branch-Verify that the user can send insurance prescription")
    public void Book_Using_Insurance_Prescription_Scan_Branch() {
        uploadAttachmentToDevice();
        performLogin();

        driver.element().click(Book_Appointment);
        driver.element().click(Select_Scan_Branch);
        driver.element().click(Select_Insurance_Prescription);
        driver.element().click(Select_Insurance_Company);
        driver.element().click(Select_EGYCare_Insurance_Company);
        driver.element().type(Phone_Number, testData.getTestData("credentials.insuranceNumber"));
        driver.element().click(Browse_Card_Btn);
        driver.element().click(Select_File);
        driver.element().click(uploadedFile);
        driver.element().click(Browse_Btn);
        driver.element().click(Select_File);
        driver.element().click(uploadedFile);
        driver.element().scrollToElement(Note);
        driver.element().click(Submit_prescription);
    }

    @Test(description = "Scan-Home-Verify that the user can Book using non insurance prescription")
    public void Book_Using_Non_Insurance_Prescription_Scan_Home() {
        uploadAttachmentToDevice();
        performLogin();

        driver.element().click(Book_Appointment);
        driver.element().click(Select_Scan_Home);
        driver.element().click(Select_Non_Insurance_Prescription);
        driver.element().click(Browse_Btn);
        driver.element().click(Select_File);
        driver.element().click(uploadedFile);
        driver.element().click(Submit_prescription);
    }

    @Test(description = "Scan-Home-Verify that the user can send insurance prescription")
    public void Book_Using_Insurance_Prescription_Scan_Home() {
        uploadAttachmentToDevice();
        performLogin();

        driver.element().click(Book_Appointment);
        driver.element().click(Select_Scan_Home);
        driver.element().click(Select_Insurance_Prescription);
        driver.element().click(Select_Insurance_Company);
        driver.element().click(Select_EGYCare_Insurance_Company);
        driver.element().type(Phone_Number, testData.getTestData("credentials.insuranceNumber"));
        driver.element().click(Browse_Card_Btn);
        driver.element().click(Select_File);
        driver.element().click(uploadedFile);
        driver.element().click(Browse_Btn);
        driver.element().click(Select_File);
        driver.element().click(uploadedFile);
        driver.element().scrollToElement(Note);
        driver.element().click(Submit_prescription);
    }

    @Test(description = "Scan-Home-Verify that the user can add M_P to cart then checkout and do partial payment.")
    public void Verify_User_Can_Book_Visit_Using_Browse_Procedure_Scan_Home() {
        performLogin();

        driver.element().click(Book_Appointment);
        driver.element().click(Select_Scan_Home);
        driver.element().click(Select_Brwose_Procedure);
        driver.element().click(Select_Xray_Modality_Home);
        driver.element().click(add_Mri_Arm_To_Cart);
        driver.element().click(Cart_Icon);
        driver.element().click(Checkout_Btn);
        driver.element().click(Next_Btn);
        driver.element().click(Select_Payment_Method);
        driver.element().click(Select_Online_Payment);
        driver.element().type(Add_Partial_Amount, testData.getTestData("payment.scanHomeAmount"));
        driver.element().click(Pay_Amount);
    }
}