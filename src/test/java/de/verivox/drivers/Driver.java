package de.verivox.drivers;

import de.verivox.driversSetUp.BaseSetup;
import io.appium.java_client.AppiumDriver;

/**
 * @Author Nicolas Duarte
 * @Version 1.0
 */
public class Driver extends BaseSetup {
    protected AppiumDriver driver;

    public Driver(){
        this.driver = super.getDriver();
    }
}
