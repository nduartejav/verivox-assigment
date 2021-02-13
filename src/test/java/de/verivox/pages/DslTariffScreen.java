package de.verivox.pages;

import de.verivox.drivers.Driver;
import de.verivox.util.SeleniumCommonsActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DslTariffScreen extends Driver {
    PageObjectDlsSelection dslSelectionRequest;
    SeleniumCommonsActions seleniumActions = new SeleniumCommonsActions();


    public DslTariffScreen() {
        super();
        dslSelectionRequest = new DslTariffScreen.PageObjectDlsSelection();
        PageFactory.initElements(driver, dslSelectionRequest);
    }


    class PageObjectDlsSelection {

        @FindBy(className = "android.widget.EditText")
        private WebElement inputAreaCode;

        @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
                "/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]" +
                "/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View" +
                "/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[6]")
        private WebElement mBits100;

        @FindBy(className = "android.widget.Button")
        private WebElement searchButton;
    }

    /**
     * Enters the area code into the area code textInput and hide the keyboard
     * @param areaCode Area code for search
     */
    public void enterAreaCode(String areaCode) {
        seleniumActions.waitUntilElementDisplayed(dslSelectionRequest.inputAreaCode, driver);
        dslSelectionRequest.inputAreaCode.click();
        dslSelectionRequest.inputAreaCode.sendKeys(areaCode);
        hideKeyboard();
    }

    /**
     * Select
     */
    public void selectDslVelocity() {
        seleniumActions.waitUntilElementDisplayed(dslSelectionRequest.mBits100, driver);
        dslSelectionRequest.mBits100.click();
    }

    public void clickSearchDsl() {
        seleniumActions.waitUntilElementDisplayed(dslSelectionRequest.searchButton, driver);
        dslSelectionRequest.searchButton.click();
    }

    public void hideKeyboard() {
        System.out.println("Hide Keyboard");
        try {
            driver.hideKeyboard();
        } catch (org.openqa.selenium.WebDriverException e) {
            System.out.println("Keyboard is not appears");
        }
    }
}
