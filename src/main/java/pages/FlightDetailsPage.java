package pages;

import helper.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.shared.Page;

/**
 * Created by aditya on 08/2019.
 */
public class FlightDetailsPage extends Page {

    public FlightDetailsPage(Browser browser) {
        super(browser);
    }

    @FindBy(css = "input[value='oneway']")
    private WebElement oneWayTrip;

}
