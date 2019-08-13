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
public class FlightConfirmationPage extends Page {
    public FlightConfirmationPage(Browser browser) {
        super(browser);
    }

    @FindBy(css = ".frame_header_info")
    private WebElement confirmationNumber;

    public boolean isConfirmationVisible(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(confirmationNumber));
        return element.isDisplayed();
    }

    public String getConfirmationNumber(){
        return confirmationNumber.getText();
    }

}
