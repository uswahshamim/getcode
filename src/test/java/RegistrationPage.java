import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import static java.lang.Thread.sleep;

public class RegistrationPage extends Utility {
    //constructor method
    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
    }

    @FindBy(how = How.LINK_TEXT, using = "Sign out")
    WebElement signOut;
    @FindBy(how = How.CSS, using = "[name='email_create']")
    WebElement enterEmail;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span")
    WebElement createAccountButton;
    @FindBy(how = How.ID, using = "id_gender2")
    WebElement genderButton;
    @FindBy(how = How.NAME, using = "customer_firstname")
    WebElement firstName;
    @FindBy(how = How.NAME, using = "customer_lastname")
    WebElement lastName;
    @FindBy(how = How.NAME, using = "passwd")
    WebElement password;
    @FindBy(how = How.NAME, using = "days")
    WebElement selectDay;
    @FindBy(how = How.NAME, using = "months")
    WebElement selectMonth;
    @FindBy(how = How.NAME, using = "years")
    WebElement selectYear;
    @FindBy(how = How.ID, using = "optin")
    WebElement checkBox;
    @FindBy(how = How.ID, using = "company")
    WebElement companyName;
    @FindBy(how = How.ID, using = "address1")
    WebElement address1;
    @FindBy(how = How.ID, using = "address2")
    WebElement address2;
    @FindBy(how = How.ID, using = "city")
    WebElement cityName;
    @FindBy(name = "id_state")
    WebElement idState;
    @FindBy(how = How.NAME, using = "postcode")
    WebElement postalCode;
    @FindBy(how = How.ID, using = "other")
    WebElement additionalInfo;
    @FindBy(how = How.ID, using = "phone")
    WebElement homePhoneNumber;
    @FindBy(how = How.ID, using = "phone_mobile")
    WebElement mobilePhoneNumber;
    @FindBy(how = How.ID, using = "alias")
    WebElement aliasAddress;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/div/div[3]/div/div/form/div[4]/button/span")
    WebElement submitRegistration;
    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement validationOfRegistration;

    public void clickSignOut() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        signOut.click();
    }

    public void enterTheEmail(String email) throws InterruptedException {
        //create account(email enter)
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        enterEmail.sendKeys(email);
    }

    //email submission
    public void clickCreateAccountButton() throws InterruptedException {
        createAccountButton.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }

    //select gender
    public void clickGenderOption() throws InterruptedException {
        genderButton.click();
    }

    //enter first name
    public void enterFirstName(String fName) throws InterruptedException {
        firstName.sendKeys(fName);
    }

    //enter last name
    public void enterLastName(String lName) throws InterruptedException {
        lastName.sendKeys(lName);
    }

    //enter password
    public void enterPassword(String pass) throws InterruptedException {
        password.sendKeys(pass);
    }

    //select date of birth
    public void selectDateOfBirth(String dValue) throws InterruptedException {
        Select drpDay = new Select(selectDay);
        drpDay.selectByValue(dValue);
    }

    //select month of birth
    public void selectMonthOfBirth(String mValue) throws InterruptedException {
        Select drpMonth = new Select(selectMonth);
        drpMonth.selectByValue(mValue);
    }

    //select year of birth
    public void selectYearOfBirth(String yValue) throws InterruptedException {
        Select drpYear = new Select(selectYear);
        drpYear.selectByValue(yValue);
    }

    //checkbox
    public void clickCheckBox() throws InterruptedException {
        //address
        checkBox.click();
    }

    //enter company
    public void enterCompanyName(String compy) throws InterruptedException {
        companyName.sendKeys(compy);
    }

    //enter first address
    public void enterAddress1(String add1) throws InterruptedException {
        address1.sendKeys(add1);
    }

    //enter second address
    public void enterAddress2(String add2) throws InterruptedException {
        address2.sendKeys(add2);
    }

    //select city
    public void enterCity(String cty) throws InterruptedException {
        cityName.sendKeys(cty);
    }

    //select state
    public void selectState(String state) throws InterruptedException {
        Select drpState = new Select(idState);
        drpState.selectByValue(state);
    }

    //enter postal code
    public void enterPostalCode(String postcode) throws InterruptedException {
        postalCode.sendKeys(postcode);
    }

    //enter additional info
    public void enterAdditionalInfo(String info) throws InterruptedException {
        additionalInfo.sendKeys(info);
    }

    //enter phone number
    public void enterHomePhoneNumber(String hNumber) throws InterruptedException {
        homePhoneNumber.sendKeys(hNumber);
    }

    //enter mobile number
    public void enterMobilePhoneNumber(String mNumber) throws InterruptedException {
        mobilePhoneNumber.sendKeys(mNumber);
    }

    //enter alias address for future
    public void enterAliasAddress(String aliasAdd) throws InterruptedException {
        aliasAddress = driver.findElement(By.id("alias"));
        aliasAddress.sendKeys(aliasAdd);
    }

    //submit registration form
    public void clickSubmitButton() throws InterruptedException {
        //submit the registration form
        submitRegistration.click();
        sleep(2000);
    }

    public void validationOfRegistration() throws InterruptedException {
        //Validation of user creation
        String userVerification = validationOfRegistration.getText();
        if (userVerification.contains("uswahshamim")) {
            System.out.println("User Verified,Test case Passed");
        } else {
            System.out.println("User Verification Failed,Test case Failed");
        }
    }
}