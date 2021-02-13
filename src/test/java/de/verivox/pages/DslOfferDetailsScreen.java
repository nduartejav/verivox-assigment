package de.verivox.pages;

import de.verivox.drivers.Driver;
import de.verivox.util.SeleniumCommonsActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DslOfferDetailsScreen extends Driver {

    PageObjectDslOfferDetails dslOfferDetails;
    SeleniumCommonsActions seleniumActions = new SeleniumCommonsActions();
    private String baseXml = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
            "/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView" +
            "/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]" +
            "/android.view.View/android.view.View/android.view.View/android.view.View[2]";

    public DslOfferDetailsScreen() {
        super();
        dslOfferDetails = new PageObjectDslOfferDetails();
        PageFactory.initElements(driver, dslOfferDetails);
    }


    class PageObjectDslOfferDetails {

        @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView" +
                "/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]" +
                "/android.view.View/android.view.View/android.view.View/android.view.View[2]" +
                "/android.view.View/android.view.View/android.view.View[2]")
        private WebElement firstPrice;

        @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView" +
                "/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]" +
                "/android.view.View/android.view.View/android.view.View/android.view.View[2]" +
                "/android.widget.GridView/android.view.View[9]/android.view.View[2]")
        private WebElement secondPrice;

        @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView" +
                "/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]" +
                "/android.view.View/android.view.View/android.view.View/android.view.View[2]" +
                "/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View" +
                "/android.view.View[1]/android.view.View/android.view.View/android.view.View[3]")
        private WebElement firstHardware;

        @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView" +
                "/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]" +
                "/android.view.View/android.view.View/android.view.View/android.view.View[2]" +
                "/android.widget.GridView/android.view.View[5]/android.view.View[1]")
        private WebElement secondHardware;

        @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup[3]")
        private WebElement goBackButton;

    }


    //Public methods

    public String getFirstPrice() {
        String price = "";


        return price;
    }

    public String getSecondPrice() {
        String price = "";


        return price;
    }


    public String getFirstHardware() {
        String hardware = "";

        return hardware;
    }

    public String getSecondHardware() {
        String hardware = "";

        return hardware;
    }

    public void goBack() {
        seleniumActions.waitUntilElementDisplayed(dslOfferDetails.goBackButton, driver);
        dslOfferDetails.goBackButton.click();
    }
}
