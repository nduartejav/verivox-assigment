package de.verivox.drivers;

import de.verivox.driversSetUp.BaseSetupUIAutomator;
import io.appium.java_client.AppiumDriver;

/**
 * @Author Nicolas Duarte
 * @Version 1.0
 */
public class DriverUIAutomator extends BaseSetupUIAutomator {
    protected AppiumDriver driver;

    public DriverUIAutomator(){
        this.driver = super.getDriver();
    }
}
