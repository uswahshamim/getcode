import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestClass extends Utility {

    @Test(priority = 1)
    public void signInTestCase1() throws InterruptedException {
        SignInPage signIn = PageFactory.initElements(driver, SignInPage.class);
        signIn.clickLinkGiven();
        signIn.enterUsername("uswahshamim777@gmail.com");
        signIn.enterPassword("48900uswah");
        signIn.clickSignInSubmitButton();
    }

    @Test(priority = 2)
    public void searchItemTestCase2() throws InterruptedException {
        SearchItemPage searchItem = PageFactory.initElements(driver, SearchItemPage.class);
        searchItem.clickSearchItemBar("Printed");
        searchItem.getListOfSearchItem();
        System.out.println("Item Searched");
    }

    @Test(priority = 3)
    public void TestUserPriceFetchProcess() throws InterruptedException {
        FetchAndPrintPage fPrice = PageFactory.initElements(driver, FetchAndPrintPage.class);
        fPrice.fetchAmount();
    }

    @Test(priority = 4)
    public void TestUserAddToCartProcess() throws InterruptedException {
        AddToCartPage addCart = PageFactory.initElements(driver, AddToCartPage.class);
        addCart.clickChangeQuantity("2");
        addCart.clickSelectSize("2");
        addCart.clickSelectColor();
        addCart.clickAddToCart();
        addCart.clickOnProceed();
        addCart.clickCheckoutPageProceed();
        addCart.clickAddress("abc");
        addCart.clickAgreeTerms();
        addCart.clickPayByCheck();
        addCart.getOrderConfirmation();
        addCart.getValidation();
    }
    @Test(priority = 5)
    public void TestUserRegistrationProcess() throws InterruptedException {
        RegistrationPage register = PageFactory.initElements(driver, RegistrationPage.class);
        register.clickSignOut();
        register.enterTheEmail("uswahshamim08@gmail.com");
        register.clickCreateAccountButton();
        register.clickGenderOption();
        register.enterFirstName("uswah");
        register.enterLastName("shamim");
        register.enterPassword("48900uswah");
        register.selectDateOfBirth("17");
        register.selectMonthOfBirth("3");
        register.selectYearOfBirth("1999");
        register.clickCheckBox();
        register.enterCompanyName("10pearls");
        register.enterAddress1("parsa tower 9th floor pechs block 6 ");
        register.enterAddress2("parsa tower 8th floor pechs block 6");
        register.enterCity("karachi");
        register.selectState("3");
        register.enterPostalCode("74600");
        register.enterAdditionalInfo("abc");
        register.enterHomePhoneNumber("03152914647");
        register.enterMobilePhoneNumber("03320374386");
        register.enterAliasAddress("gulshan");
        register.clickSubmitButton();
        register.validationOfRegistration();
    }
}