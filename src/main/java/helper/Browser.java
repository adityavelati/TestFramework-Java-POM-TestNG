package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by aditya on 08/2019.
 */
public class Browser {


    public Browser(String browserName, String baseUrl) {
        setBrowser(browserName);
        setBaseUrl(baseUrl);
        Initialise(getBrowser());
    }

    private void Initialise(String browser) {
        capabilities = new DesiredCapabilities();

        seleniumFolderPath = "src";

        if (browser.equals("Chrome")) {

            ChromeOptions chrome_options = new ChromeOptions();
            if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                System.setProperty("webdriver.chrome.driver", seleniumFolderPath + "/test/resources/drivers/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", seleniumFolderPath + "\\test\\resources\\drivers\\chromedriver.exe");
            }
            capabilities.setBrowserName("chrome");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chrome_options);
            _driver = new ChromeDriver(capabilities);
        } else if (browser.equals("Safari")) {
            capabilities.setBrowserName("safari");
            _driver = new SafariDriver();
        } else if (browser.equals("Firefox")) {
            FirefoxProfile ff_profile = new FirefoxProfile();
            ff_profile.setPreference("geo.prompt.testing", true);
            ff_profile.setPreference("geo.prompt.testing.allow", true);
            System.setProperty("webdriver.gecko.driver", seleniumFolderPath + "geckodriver");
            capabilities.setBrowserName("firefox");
            capabilities.setCapability(FirefoxDriver.PROFILE, ff_profile);
            _driver = new FirefoxDriver(capabilities);
        } else if (browser.equals("InternetExplorer")) {

            System.setProperty("webdriver.ie.driver", seleniumFolderPath + "IEDriverServer.exe");
            capabilities.setBrowserName("internet explorer");
        } else if (browser.equals("Edge")) {

            System.setProperty("webdriver.edge.driver", seleniumFolderPath + "MicrosoftWebDriver.exe");
            capabilities.setBrowserName("edge");
        } else {
            System.out.println("Invalid browser passed in: " + browser);
        }

        _driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void navigateTo(String url) {
        _driver.get(url);
    }

    public void navigateToBaseUrl() {
        _driver.get(getBaseUrl());
    }

    public String getBrowser() {
        return this.browserName;
    }

    private void setBrowser(String browserName) {
        this.browserName = browserName;
    }

    private void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public LoginPage HomePage() {
        if (homePage == null) {
            homePage = new LoginPage(this);
        }
        return homePage;
    }

    // Public properties
    public WebDriver _driver;

    // Private properties
    private DesiredCapabilities capabilities;
    private String browserName;
    private String baseUrl;
    private String seleniumFolderPath;
    private LoginPage homePage;
}
