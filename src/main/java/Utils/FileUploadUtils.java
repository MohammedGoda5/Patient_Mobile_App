package Utils;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class FileUploadUtils {

    /**
     * Pushes a local file to the emulator/device standard storage directory.
     *
     * @param driver         SHAFT WebDriver instance
     * @param localFilePath  Relative path to the local test file
     * @param deviceFilePath Destination path on the Android device
     */
    public static void uploadFileToDevice(Object driver, String localFilePath, String deviceFilePath) {
        try {
            File localFile = new File(localFilePath);
            ((AndroidDriver) driver).pushFile(deviceFilePath, localFile);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Failed to push file to device: " + e.getMessage());
        }
    }
}