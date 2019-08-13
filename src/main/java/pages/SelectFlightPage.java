package pages;

import helper.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.shared.Page;

/**
 * Created by aditya on 08/2019.
 */
public class SelectFlightPage extends Page {

    public SelectFlightPage(Browser browser) {
        super(browser);
    }

    @FindBy(name = "reserveFlights")
    private WebElement reserveFlights;

    public boolean isReserveFlights(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(reserveFlights));
        return element.isDisplayed();
    }

    public void clickOnContinue(){
        reserveFlights.click();
    }

}
