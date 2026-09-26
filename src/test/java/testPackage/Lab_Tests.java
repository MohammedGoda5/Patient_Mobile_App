package testPackage;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Lab_Tests extends BaseTest {

    // Lab Specific Locators
    private final By Select_Lab_Home = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Lab, Home Visit']/android.view.ViewGroup[3]");
    private final By Select_Lab_Branch = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Lab, Branch Visit']/android.view.ViewGroup[3]");
    private final By Select_Lab_Modality = AppiumBy.xpath("(//android.widget.TextView[@text='LAB'])[1]");
    private final By Add_SDD_To_Cart = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]");
    private final By Pay_Amount_SDD = AppiumBy.accessibilityId("Pay ( 300.00 EGP )");
    private final By Select_Lab_Insurance_Prescription = AppiumBy.accessibilityId("Continue");

    @Test(description = "Lab-Home-Verify that the user can Book using non insurance prescription")
    public void Book_Using_Non_Insurance_Prescription_Lab_Home() {
        uploadAttachmentToDevice();
        performLogin();

        driver.element().click(Book_Appointment);
        driver.element().click(Select_Lab_Home);
        driver.element().click(Select_Non_Insurance_Prescription);
        driver.element().click(Browse_Btn);
        driver.element().click(Select_File);
        driver.element().click(uploadedFile);
        driver.element().click(Submit_prescription);
    }

    @Test(description = "Lab-Home-Verify that the user can send insurance prescription")
    public void Book_Using_Insurance_Prescription_Lab_Home() {
        uploadAttachmentToDevice();
        performLogin();

        driver.element().click(Book_Appointment);
        driver.element().click(Select_Lab_Home);
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

    @Test(description = "Lab-Home-Verify that the user can add M_P to cart then checkout and do partial payment.")
    public void Verify_User_Can_Book_Visit_Using_Browse_Procedure_Lab_Home() {
        performLogin();

        driver.element().click(Book_Appointment);
        driver.element().click(Select_Lab_Home);
        driver.element().click(Select_Brwose_Procedure);
        driver.element().click(Select_Lab_Modality);
        driver.element().click(Add_SDD_To_Cart);
        driver.element().click(Cart_Icon);
        driver.element().click(Checkout_Btn);
        driver.element().click(Next_Btn);
        driver.element().click(Select_Payment_Method);
        driver.element().click(Select_Online_Payment);
        driver.element().type(Add_Partial_Amount, testData.getTestData("payment.labHomeAmount"));
        driver.element().click(Pay_Amount_SDD);
    }

    @Test(description = "Lab-Branch-Verify that the user can send insurance prescription")
    public void Book_Using_Insurance_Prescription_Lab_Branch() {
        uploadAttachmentToDevice();
        performLogin();

        driver.element().click(Book_Appointment);
        driver.element().click(Select_Lab_Branch);
        driver.element().click(Select_Lab_Insurance_Prescription);
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
}