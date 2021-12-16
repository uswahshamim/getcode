import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class FetchAndPrintPage extends Utility {
    //constructor method
    public FetchAndPrintPage(WebDriver driver) {

        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@id='our_price_display']")
    WebElement price;
    String fetchPrice;

    //fetch and print price of searched item also compare the fetched price with expected price
    public void fetchAmount() throws InterruptedException {
        fetchPrice = price.getText();
        System.out.println(fetchPrice);
        String expPrice = "$16.40";
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        Assert.assertEquals(expPrice, fetchPrice);
    }


}