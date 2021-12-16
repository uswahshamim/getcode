import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class AddToCartPage extends Utility {
    //constructor method
    public AddToCartPage(WebDriver driver) {

        this.driver = driver;
    }
    @FindBy(how = How.ID, using = "quantity_wanted")WebElement changeQuantity;
    @FindBy(name = "group_1")WebElement selectSize;
    @FindBy(id="color_15")WebElement selectColor;
    @FindBy(how = How.XPATH,using = "//*[@id='add_to_cart']/button/span")WebElement addToCart;
    @FindBy(how = How.XPATH,using = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")WebElement proceedOption;
    @FindBy(how = How.XPATH,using = "/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span")WebElement checkoutPageProceedOption;
    @FindBy(how = How.NAME,using = "message")WebElement msgAddress;
    @FindBy(how = How.XPATH,using = "/html/body/div/div[2]/div/div[3]/div/form/p/button/span")WebElement address;
    @FindBy(how = How.NAME,using = "cgv")WebElement agreeTermsCheckBox;
    @FindBy(how = How.XPATH,using = "//*[@id='form']/p/button/span")WebElement agreeTermsSubmitButton;
    @FindBy(how = How.XPATH,using = "/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")WebElement payByCheck;
    @FindBy(how = How.XPATH,using = "/html/body/div/div[2]/div/div[3]/div/form/p/button/span")WebElement orderConfirmation;
    @FindBy(how = How.XPATH,using = "//div[@id='center_column']/p[@class='alert alert-success']")WebElement validationOfAddToCart;

    //Change quantity by 2
    public void clickChangeQuantity(String quantity) throws InterruptedException {
        changeQuantity.clear();
        changeQuantity.sendKeys(quantity);
    }

    //Select size as M
    public void clickSelectSize(String value) throws InterruptedException {

        Select dropdown = new Select(selectSize);
        dropdown.selectByValue(value);
    }
    //Select Color
    public void clickSelectColor() throws InterruptedException {
        selectColor.click();
    }

    //Click on add to cart
    public void clickAddToCart() throws InterruptedException {
        addToCart.click();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }
    //Click on proceed
    public void clickOnProceed() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        proceedOption.click();
    }
    //1st step of Checkout page Proceed
    public void clickCheckoutPageProceed() throws InterruptedException {
        checkoutPageProceedOption.click();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }

    //3rd step address
    public void clickAddress(String message) throws InterruptedException {
        msgAddress.sendKeys(message);
        address.click();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }
    //4th step of Agree terms&Conditions
    public void clickAgreeTerms() throws InterruptedException {
        agreeTermsCheckBox.click();
        agreeTermsSubmitButton.click();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }
    //5th step of Click on Payby Check
    public void clickPayByCheck() {

        payByCheck.click();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }
    //6th step of order confirmation
    public void getOrderConfirmation() throws InterruptedException {

        orderConfirmation.click();
     // driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }

    public void getValidation() throws InterruptedException {
        //Get Text and store it in a string
        String ConfirmationText = validationOfAddToCart.getText();
        // Verify that Product is being ordered
        if (ConfirmationText.contains("complete")) {
            System.out.println("Order Completed: Test Case Passed");

        } else {
            System.out.println("Order Not Successful: Test Case Failed");
        }
    }
}
