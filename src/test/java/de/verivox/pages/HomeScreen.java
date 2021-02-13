package de.verivox.pages;

import de.verivox.drivers.Driver;
import de.verivox.util.SeleniumCommonsActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen extends Driver {

    PageObjectSelectOptions selectOptionsRequest;
    SeleniumCommonsActions seleniumActions = new SeleniumCommonsActions();

    public HomeScreen(){
        super();
        selectOptionsRequest = new PageObjectSelectOptions();
        PageFactory.initElements(driver, selectOptionsRequest);
    }


    class PageObjectSelectOptions{

        @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
                "/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]" +
                "/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]")
        public WebElement dslButton;


    }


    public void selectDslOption() {

        seleniumActions.waitUntilElementDisplayed(selectOptionsRequest.dslButton, driver);
        selectOptionsRequest.dslButton.click();

    }
}
