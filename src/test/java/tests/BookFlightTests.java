package tests;

import helper.Browser;
import helper.TestHelper;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

/**
 * Created by aditya on 08/2019.
 */
public class BookFlightTests extends TestHelper {

    Browser browser;
    LoginPage loginPage;
    FlightDetailsPage flightDetailsPage;
    SelectFlightPage selectFlightPage;
    BookFlightPage bookFlightPage;
    FlightConfirmationPage flightConfirmationPage;

    @Parameters({"browserName", "baseUrl"})
    @BeforeClass(groups = {"web"})
    public void setUp(String browserName, String baseUrl) {
        browser = new Browser(browserName, baseUrl);
        browser.navigateToBaseUrl();
    }

    @Test(groups = {"web"})
    public void login() throws Exception {

        //Login into Flight booking system
        loginPage = new LoginPage(browser);
        flightDetailsPage = new FlightDetailsPage(browser);
        loginPage.loginToFlightBooking("mercury", "mercury");

        //Verify login is successful
        Assert.assertEquals(flightDetailsPage.isFindFlightVisible(), true);
    }

    @Test(dependsOnMethods = {"login"}, groups = {"web"})
    public void findFlight() throws Exception {

        //Enter all From and To in Flight details page
        selectFlightPage = new SelectFlightPage(browser);
        flightDetailsPage.enterFlightDetails("oneway","Sydney", "London", "first");
        flightDetailsPage.clickOnContinue();

        //Verify select Flight page is displayed
        Assert.assertEquals(selectFlightPage.isReserveFlights(), true);
    }

    @Test(dependsOnMethods = {"findFlight"}, groups = {"web"})
    public void bookFlight() throws Exception {

        //Continue with default flight selection on select flight page
        selectFlightPage.clickOnContinue();

        //Verify Book Flight page is displayed
        bookFlightPage = new BookFlightPage(browser);
        Assert.assertEquals(bookFlightPage.isBuyFlightVisible(), true);

        //Enter payment details in Book Flight page
        bookFlightPage.enterPassengerDetails("Test", "Test", "123456");
        flightConfirmationPage = new FlightConfirmationPage(browser);

        //Verify Payment is successful and Confirmation number is generated
        Assert.assertEquals(flightConfirmationPage.isConfirmationVisible(), true);
        Assert.assertTrue(flightConfirmationPage.getConfirmationNumber().contains("Confirmation"));
        System.out.println(" ############flight number######## : " + flightConfirmationPage.getConfirmationNumber());
    }

    @AfterClass(groups = {"web"})
    public void tearDown() {
        browser._driver.quit();
    }

}
