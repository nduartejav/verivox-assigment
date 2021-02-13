package de.verivox.testSuite;

import de.verivox.models.DslOffer;
import de.verivox.pages.*;
import org.junit.Before;
import org.junit.Test;

import static de.verivox.constant.GermanyAreaCodes.BERLIN_AREA_CODE;

public class VerifyOfferDetails {

    private String areaCode = BERLIN_AREA_CODE;
    private HomeScreen homeScreen;
    private CookiePopupScreen cookiePopupScreen;
    private DslTariffScreen dslTariffScreen;
    private DslResultsScreen dslResultsScreen;
    private DslOfferDetailsScreen dslOfferDetailsScreen;


    @Before
    public void preconditions() {

    }

    @Test
    public void verifyOfferDetailsTest() {
        homeScreen = new HomeScreen();
        homeScreen.selectDslOption();

        cookiePopupScreen = new CookiePopupScreen();
        cookiePopupScreen.acceptCookies();

        dslTariffScreen = new DslTariffScreen();
        dslTariffScreen.enterAreaCode(areaCode);
        dslTariffScreen.selectDslVelocity();
        dslTariffScreen.clickSearchDsl();

        dslResultsScreen = new DslResultsScreen();
        dslResultsScreen.goToOffer();


        dslOfferDetailsScreen = new DslOfferDetailsScreen();



        dslOfferDetailsScreen.goBack();
    }
}
