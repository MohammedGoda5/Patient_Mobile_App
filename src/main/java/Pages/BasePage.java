package Pages;

import com.shaft.driver.SHAFT;

public class BasePage {
    protected SHAFT.GUI.WebDriver driver;

    public BasePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
}