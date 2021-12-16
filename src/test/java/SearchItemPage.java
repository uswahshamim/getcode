import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchItemPage extends Utility {
    //constructor method
    public SearchItemPage(WebDriver driver) {

        this.driver = driver;
    }

    @FindBy(name = "search_query")
    WebElement searchTheItem;

    //enter the word
    public void clickSearchItemBar(String enterWord) throws InterruptedException {
        searchTheItem.sendKeys(enterWord);
    }

    //search the item in dynamic list
    public void getListOfSearchItem() throws InterruptedException {
        List<WebElement> list = driver.findElements(By.xpath("//ul//li[contains(@class, 'ac_')]"));
        //System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            String listItem = list.get(i).getText();
            //element.get(index) get elements 1 by 1 from array
            //getText() returns String value of text associated to that swing object, GetText returns the text from the single-line text field
            if (listItem.contains("Printed Chiffon Dress")) {
                driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
                //ArrayList contains() method in Java is used for checking if the specified element exists in the given list or not.
                list.get(i).click();
                break;
            }

        }
    }

}
