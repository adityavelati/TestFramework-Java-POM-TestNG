package tests;

import helper.Browser;
import helper.TestHelper;
import org.testng.annotations.*;
import pages.LoginPage;

/**
 * Created by aditya on 08/2019.
 */
public class LoginPageTests extends TestHelper {

    Browser browser;
    LoginPage loginPage;

    @Parameters({"browserName", "baseUrl"})
    @BeforeClass(groups = {"web"})
    public void setUp(String browserName, String baseUrl) {
        browser = new Browser(browserName, baseUrl);
        browser.navigateToBaseUrl();
    }

    @Test(groups = {"web"})
    public void login() throws InterruptedException {
        loginPage = new LoginPage(browser);
        loginPage.loginToFlightBooking("mercury", "mercury");

    }

    @AfterClass(groups = {"web"})
    public void tearDown() {
        browser._driver.quit();
    }

}
