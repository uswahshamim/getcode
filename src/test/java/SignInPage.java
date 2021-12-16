import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

public class SignInPage extends Utility {
    //constructor method
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.LINK_TEXT, using = "Sign in")
    WebElement linkGiven;
    @FindBy(name = "email")
    WebElement username;
    @FindBy(name = "passwd")
    WebElement password;
    @FindBy(how = How.ID, using = "SubmitLogin")
    WebElement signInSubmitButton;

    //click sing in link
    public void clickLinkGiven() {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        linkGiven.click();
    }

    //enter user name(email)
    public void enterUsername(String emailAddress) {
        username.sendKeys(emailAddress);
    }

    //enter password
    public void enterPassword(String passwd) {
        password.sendKeys(passwd);
    }

    //signIn submit button
    public void clickSignInSubmitButton() {
        signInSubmitButton.click();
    }

}

