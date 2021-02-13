package de.verivox.driversSetUp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author Nicolas Duarte
 * @Version 1.0
 */
public class BaseSetupUIAutomator {

    private static AppiumDriver appiumDriver;

    public AppiumDriver getDriver(){
        if(appiumDriver ==null) {
            initDriver();
        }
        return appiumDriver;
    }

    private void initDriver(){

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        cap.setCapability("automationName", "uiautomator");
        cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability("noReset", true);
        cap.setCapability("fullReset", false);
        cap.setCapability(MobileCapabilityType.APP, "/Users/nicolas.duarte/Downloads/verivox_3.2.3.apk");

        String serverUrl = "http://127.0.0.1:4723/wd/hub";

        try {

            appiumDriver = new AppiumDriver(new URL(serverUrl), cap);
        }
        catch (NullPointerException | MalformedURLException ex) {
            throw new RuntimeException("Appium driver could not be initialized for device ");
        }
    }
}
