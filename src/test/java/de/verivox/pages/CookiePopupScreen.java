package de.verivox.pages;

import de.verivox.drivers.Driver;
import de.verivox.util.SeleniumCommonsActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiePopupScreen extends Driver {

    CookiePopupSelection cookiePopupRequest;
    SeleniumCommonsActions seleniumActions = new SeleniumCommonsActions();

    public CookiePopupScreen(){
        super();
        cookiePopupRequest = new CookiePopupSelection();
        PageFactory.initElements(driver, cookiePopupRequest);
    }

    class CookiePopupSelection{
        @FindBy(id = "uc-btn-accept-banner")
        private WebElement acceptButton;

        @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView" +
                "/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]" +
                "/android.widget.Button[2]")
        private WebElement acceptButton2;

    }

    public void acceptCookies(){
        seleniumActions.waitUntilElementDisplayed( cookiePopupRequest.acceptButton2, driver);
        cookiePopupRequest.acceptButton2.click();
    }

    public void deniedCookies(){
        //TODO
    }
}
