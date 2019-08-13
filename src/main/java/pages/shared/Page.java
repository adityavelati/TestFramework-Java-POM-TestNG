package pages.shared;

import helper.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by aditya on 08/2019.
 */
public class Page {

    public Page(Browser browser) {
        this.browser = browser;
        driver = browser._driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Browser browser;
    protected static int DURATION = 5000;
}
