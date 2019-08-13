package pages;

import helper.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @FindBy(css = "input[value='roundtrip']")
    private WebElement roundTrip;

    @FindBy(name = "findFlights")
    private WebElement findFlights;

    @FindBy(name = "fromPort")
    private WebElement fromPort;

    @FindBy(name = "toPort")
    private WebElement toPort;

    @FindBy(css = "input[value='First']")
    private WebElement firstClass;

    @FindBy(css = "input[value='Business']")
    private WebElement businessClass;

    @FindBy(css = "input[value='Coach']")
    private WebElement economyClass;

    public boolean isFindFlightVisible(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(findFlights));
        return element.isDisplayed();
    }

    public void enterFlightDetails(String tripType, String fromPlace, String toPlace, String flightClass){
        if (tripType.toLowerCase().trim().equals("oneway")) {
            oneWayTrip.click();
        } else {
            roundTrip.click();
        }
        Select from = new Select(fromPort);
        from.selectByValue(fromPlace);

        Select to = new Select(toPort);
        to.selectByValue(toPlace);

        if (flightClass.toLowerCase().trim().equals("first")){
            firstClass.click();
        } else if(flightClass.toLowerCase().trim().equals("business")){
            businessClass.click();
        } else {
            economyClass.click();
        }
    }

    public void clickOnContinue(){
        findFlights.click();
    }



}
