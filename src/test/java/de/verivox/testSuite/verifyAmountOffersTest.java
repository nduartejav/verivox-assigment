package de.verivox.testSuite;

import de.verivox.pages.CookiePopupScreen;
import de.verivox.pages.DslResultsScreen;
import de.verivox.pages.DslTariffScreen;
import de.verivox.pages.HomeScreen;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class verifyAmountOffersTest {

    private String areaCode = "030";
    private HomeScreen homeScreen;
    private CookiePopupScreen cookiePopupScreen;
    private DslTariffScreen dslTariffScreen;
    private DslResultsScreen dslResultsScreen;
    private int pagination = 20;

    @Before
    public void preconditions() {

    }

    @Test
    public void verifyDslCalculatorTest() {
        //Amunt of tariffs
        int tariffs = 0;
        int tariffsLeft = 0;
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

        tariffsLeft = tariffs - pagination;

        while (tariffsLeft > 0) {
            if (tariffsLeft > pagination) {
               assertTrue( dslResultsScreen.loadMoreOffers(pagination));
            } else {
                assertTrue( dslResultsScreen.loadMoreOffers(tariffsLeft));
            }
            tariffsLeft = tariffsLeft - pagination;
        }
    }
}
