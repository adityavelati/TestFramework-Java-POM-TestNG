package pages;

import helper.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.shared.Page;

/**
 * Created by aditya on 08/2019.
 */
public class LoginPage extends Page {

    public LoginPage(Browser browser) {
        super(browser);
    }

    @FindBy(name = "userName")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "login")
    private WebElement signIn;

    public void loginToFlightBooking(String user, String pwd){
        userName.sendKeys(user);
        password.sendKeys(pwd);
        signIn.click();
    }

}
