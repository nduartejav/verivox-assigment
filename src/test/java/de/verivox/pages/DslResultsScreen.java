package de.verivox.pages;

import de.verivox.drivers.Driver;
import de.verivox.util.SeleniumCommonsActions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DslResultsScreen extends Driver {
    PageObjectDlsResult dlsResultRequest;
    SeleniumCommonsActions seleniumActions = new SeleniumCommonsActions();

    String baseXml = "";

    public DslResultsScreen() {
        super();
        dlsResultRequest = new DslResultsScreen.PageObjectDlsResult();
        PageFactory.initElements(driver, dlsResultRequest);
    }


    //Map of elemts
    class PageObjectDlsResult {

        @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView" +
                "/android.webkit.WebView/android.view.View/android.view.View/android.view.View" +
                "/android.view.View[2]/android.view.View[3]/android.view.View[1]/android.view.View")
        private WebElement tarrif;

        @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView" +
                "/android.webkit.WebView/android.view.View/android.view.View/android.view.View" +
                "/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]" +
                "/android.view.View[3]/android.view.View/android.view.View[1]/android.widget.TextView[1]")
        private WebElement offerDownloadVelocity;

        @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView" +
                "/android.webkit.WebView/android.view.View/android.view.View/android.view.View" +
                "/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]" +
                "/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.TextView[1]")
        private WebElement offerDownloadVelocity2;

        @FindBy(xpath = "//android.view.View[@content-desc=\"ZUM ANGEBOT\"]")
        private WebElement offerDetails;

        @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView" +
                "/android.webkit.WebView/android.view.View/android.view.View/android.view.View" +
                "/android.view.View/android.view.View[3]/android.widget.Button")
        private WebElement loadMoreOffersButton;
    }

    public int returnAmountOfTarrifs() {
        int res = 0;

        seleniumActions.waitUntilElementDisplayed(dlsResultRequest.tarrif, driver);
        String ta = dlsResultRequest.tarrif.getAttribute("text");
        String[] tariff = ta.split(" ");
        res = Integer.parseInt(tariff[0]);

        return res;
    }

    public int returnVelocity() {
        int res = 0;

        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10)" +
                        ".scrollIntoView(new UiSelector().text(\"ZUM ANGEBOT\"))"));

        res = Integer.parseInt(dlsResultRequest.offerDownloadVelocity2.getAttribute("text").trim());

        return res;
    }

    public void goToOffer() {

        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10)" +
                        ".scrollIntoView(new UiSelector().text(\"ZUM ANGEBOT\"))"));

        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10)" +
                        ".scrollIntoView(new UiSelector().text(\"ZUM ANGEBOT\"))")).click();
    }


    public Boolean loadMoreOffers(int tariffs) {

        Boolean res = false;
        String buttonText = tariffs + " WEITERE TARIFE LADEN";

        System.out.println(tariffs + " WEITERE TARIFE LADEN");
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(30)" +
                        ".scrollIntoView(new UiSelector().text(\"" + buttonText + "\"))"));

        List<WebElement> buttons = driver.findElementsByClassName("android.widget.Button");
        for (WebElement elem: buttons
             ) {
            if(elem.getText().equals(buttonText)){
                elem.click();
                res = true;
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        return res;
    }
}
