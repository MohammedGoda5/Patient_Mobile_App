package Test_Package;

import org.testng.annotations.Test;


public class LabTests extends Base_Test {

    @Test(description = "Lab-Home-Verify that the user can Book using non insurance prescription")
    public void Book_Using_Non_Insurance_Prescription_Lab_Home() {
        uploadAttachmentToDevice();

        performLogin()
                .clickBookAppointment()
                .selectLabHome()
                .selectNonInsurancePrescription()
                .uploadPrescriptionImage()
                .clickSubmit();
    }

    @Test(description = "Lab-Home-Verify that the user can send insurance prescription")
    public void Book_Using_Insurance_Prescription_Lab_Home() {
        uploadAttachmentToDevice();

        performLogin()
                .clickBookAppointment()
                .selectLabHome()
                .selectInsurancePrescription()
                .selectInsuranceCompany()
                .enterInsuranceNumber(testData.getTestData("credentials.insuranceNumber"))
                .uploadCardImage()
                .uploadPrescriptionImage()
                .scrollToNote()
                .clickSubmit();
    }

    @Test(description = "Lab-Home-Verify that the user can add M_P to cart then checkout and do partial payment.")
    public void Verify_User_Can_Book_Visit_Using_Browse_Procedure_Lab_Home() {
        performLogin()
                .clickBookAppointment()
                .selectLabHome()
                .selectBrowseProcedure()
                .selectLabModality()
                .addSddToCart()
                .openCart()
                .clickCheckout()
                .clickNext()
                .selectOnlinePaymentMethod()
                .enterPartialAmount(testData.getTestData("payment.labHomeAmount"))
                .clickPaySdd();
    }

    @Test(description = "Lab-Branch-Verify that the user can send insurance prescription")
    public void Book_Using_Insurance_Prescription_Lab_Branch() {
        uploadAttachmentToDevice();

        performLogin()
                .clickBookAppointment()
                .selectLabBranch()
                .selectLabInsurancePrescription()
                .selectInsuranceCompany()
                .enterInsuranceNumber(testData.getTestData("credentials.insuranceNumber"))
                .uploadCardImage()
                .uploadPrescriptionImage()
                .scrollToNote()
                .clickSubmit();
    }
}