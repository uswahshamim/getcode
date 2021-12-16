import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Utility {

    public WebDriver driver;

    //Open Browser
    @BeforeTest
    public void LaunchBrowser() {

        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\uswa.shamim\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/");
    }

    //Close Browser
    @AfterTest
    public void CloseBrowser() {
        driver.quit();
    }
}
