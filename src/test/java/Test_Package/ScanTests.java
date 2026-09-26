package Test_Package;

import org.testng.annotations.Test;
import testPackage.BaseTest;


public class ScanTests extends Base_Test {

    @Test(description = "Scan-Branch-Verify that the user can add M_P to cart then checkout and do partial payment.")
    public void Verify_User_Can_Book_Visit_Using_Browse_Procedure_Scan_Branch() {
        performLogin()
                .clickBookAppointment()
                .selectScanBranch()
                .selectBrowseProcedure()
                .selectXrayModalityBranch()
                .addMriArmToCart()
                .openCart()
                .clickCheckout()
                .selectScanBranches()
                .clickNext()
                .selectOnlinePaymentMethod()
                .enterPartialAmount(testData.getTestData("payment.scanBranchAmount"))
                .clickPayScan();
    }

    @Test(description = "Scan-Branch-Verify that the user can Book using non insurance prescription")
    public void Book_Using_Non_Insurance_Prescription_Scan_Branch() {
        uploadAttachmentToDevice();

        performLogin()
                .clickBookAppointment()
                .selectScanBranch()
                .selectNonInsurancePrescription()
                .uploadPrescriptionImage()
                .clickSubmit();
    }

    @Test(description = "Scan-Branch-Verify that the user can send insurance prescription")
    public void Book_Using_Insurance_Prescription_Scan_Branch() {
        uploadAttachmentToDevice();

        performLogin()
                .clickBookAppointment()
                .selectScanBranch()
                .selectInsurancePrescription()
                .selectInsuranceCompany()
                .enterInsuranceNumber(testData.getTestData("credentials.insuranceNumber"))
                .uploadCardImage()
                .uploadPrescriptionImage()
                .scrollToNote()
                .clickSubmit();
    }

    @Test(description = "Scan-Home-Verify that the user can Book using non insurance prescription")
    public void Book_Using_Non_Insurance_Prescription_Scan_Home() {
        uploadAttachmentToDevice();

        performLogin()
                .clickBookAppointment()
                .selectScanHome()
                .selectNonInsurancePrescription()
                .uploadPrescriptionImage()
                .clickSubmit();
    }

    @Test(description = "Scan-Home-Verify that the user can send insurance prescription")
    public void Book_Using_Insurance_Prescription_Scan_Home() {
        uploadAttachmentToDevice();

        performLogin()
                .clickBookAppointment()
                .selectScanHome()
                .selectInsurancePrescription()
                .selectInsuranceCompany()
                .enterInsuranceNumber(testData.getTestData("credentials.insuranceNumber"))
                .uploadCardImage()
                .uploadPrescriptionImage()
                .scrollToNote()
                .clickSubmit();
    }

    @Test(description = "Scan-Home-Verify that the user can add M_P to cart then checkout and do partial payment.")
    public void Verify_User_Can_Book_Visit_Using_Browse_Procedure_Scan_Home() {
        performLogin()
                .clickBookAppointment()
                .selectScanHome()
                .selectBrowseProcedure()
                .selectXrayModalityHome()
                .addMriArmToCart()
                .openCart()
                .clickCheckout()
                .clickNext()
                .selectOnlinePaymentMethod()
                .enterPartialAmount(testData.getTestData("payment.scanHomeAmount"))
                .clickPayScan();
    }
}