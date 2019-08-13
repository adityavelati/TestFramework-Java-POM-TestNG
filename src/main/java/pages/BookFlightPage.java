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
public class BookFlightPage extends Page {

    public BookFlightPage(Browser browser) {
        super(browser);
    }

    @FindBy(name = "passFirst0")
    private WebElement firstName;

    @FindBy(name = "passLast0")
    private WebElement lastName;

    @FindBy(name = "creditnumber")
    private WebElement cardNumber;

    @FindBy(name = "cc_frst_name")
    private WebElement cardFirstName;

    @FindBy(name = "cc_last_name")
    private WebElement cardLastName;

    @FindBy(name = "buyFlights")
    private WebElement buyTicket;

    public boolean isBuyFlightVisible(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(buyTicket));
        return element.isDisplayed();
    }

    public void enterPassengerDetails(String fName, String lName, String cNumber){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        cardNumber.sendKeys(cNumber);
        cardFirstName.sendKeys(fName);
        cardLastName.sendKeys(lName);
        buyTicket.click();
    }


}
