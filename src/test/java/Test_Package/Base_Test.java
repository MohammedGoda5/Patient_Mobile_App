package Test_Package;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.FileUploadUtils;

public class Base_Test {

    protected SHAFT.GUI.WebDriver driver;
    protected SHAFT.TestData.JSON testData;

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

    protected HomePage performLogin() {
        return new LoginPage(driver)
                .resetAppToBackground()
                .selectEnglishLanguageAndSkip()
                .login(
                        testData.getTestData("credentials.validPhone"),
                        testData.getTestData("credentials.password")
                )
                .verifyBookAppointmentVisible();
    }

    protected void uploadAttachmentToDevice() {
        FileUploadUtils.uploadFileToDevice(
                driver.getDriver(),
                testData.getTestData("fileData.localPath"),
                testData.getTestData("fileData.devicePath")
        );
    }
}