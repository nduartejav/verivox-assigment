package de.verivox.testSuite;

import de.verivox.pages.CookiePopupScreen;
import de.verivox.pages.DslResultsScreen;
import de.verivox.pages.HomeScreen;
import de.verivox.pages.DslTariffScreen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Before;
import org.junit.Test;

import static de.verivox.constant.GermanyAreaCodes.BERLIN_AREA_CODE;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Test report for dls comparison")
@Feature("Inital feature")
public class DslComparationTest {

    private String areaCode = BERLIN_AREA_CODE;
    private HomeScreen homeScreen;
    private CookiePopupScreen cookiePopupScreen;
    private DslTariffScreen dslTariffScreen;
    private DslResultsScreen dslResultsScreen;
    private Integer minTarifss = 5;
    private int minDownloadVel = 100;

    @Before
    public void preconditions() {

    }

    @Test
    @Story("Base support for bdd annotations")
    public void verifyDslCalculatorTest() {
        //Amunt of tariffs
        int tariffs = 0;
        homeScreen = new HomeScreen();
        homeScreen.selectDslOption();

        cookiePopupScreen = new CookiePopupScreen();

        cookiePopupScreen.acceptCookies();

        dslTariffScreen = new DslTariffScreen();
        dslTariffScreen.enterAreaCode(areaCode);
        dslTariffScreen.selectDslVelocity();
        dslTariffScreen.clickSearchDsl();

        dslResultsScreen = new DslResultsScreen();
        tariffs = dslResultsScreen.returnAmountOfTarrifs();

        assertTrue(minTarifss <= tariffs,
                "The amount of tariffs are less than minimum");

        int velocity = dslResultsScreen.returnVelocity();
        assertTrue(minDownloadVel <= velocity,
                "The velocity is less than minimum");

    }
}
