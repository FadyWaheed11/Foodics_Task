package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ui.data_driven.ShippingData;
import ui.pages.*;
import static ui.data_driven.ShippingData.getShippingData;
import static ui.pages.CartPage.getCartPage;
import static ui.pages.CheckOutPage.getCheckOutPage;
import static ui.pages.HomePage.getHomePage;
import static ui.pages.SignInPage.getSignInPage;
import static ui.pages.VideoGamesPage.getVideoGamesPage;
import static ui.utils.DriverFactory.quitDriver;
import static ui.utils.Settings.homeUrl;
import static ui.utils.SharedSteps.goToUrl;
import static ui.utils.SharedSteps.maximizeScreen;

public class AddProductTest {
    HomePage homePage = getHomePage();
    VideoGamesPage videoGamesPage = getVideoGamesPage();
    CartPage cartPage = getCartPage();
    SignInPage signInPage = getSignInPage();
    ShippingData shippingData = getShippingData();
    CheckOutPage checkOutPage = getCheckOutPage();
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {
        goToUrl(homeUrl); //STEP 1 -> Open https://www.amazon.eg/ and login
        maximizeScreen();
    }

    @Test
    public void testAddProductsLess15kToCart() {
        homePage.clickOnLeftSideMenu() //STEP 2 -> open “All” menu from the left side
                .clickOnVideoGames()
                .clickOnAllVideoGames(); //STEP 3 -> click on “video games” then choose “all video games”

        videoGamesPage.clickOnFreeShippingFilter() //STEP 4 -> from the filter menu on the left side add filter “free shipping”
                .clickOnNewConditionFilter() //& add the filter of condition "new"
                .clickOnFilterByPrice() //STEP 5 -> in the right side open the sort menu then sort by price: high to low
                .addProductToCart(); //STEP 6 ->  add all products below that its cost below 15k EGP , if no product below 15k EGP move to next page

        int actualNumOfProductsInTheCart = videoGamesPage.getCartCount();//STEP 7 -> make sure that all products is already added to carts
        softAssert.assertEquals(actualNumOfProductsInTheCart,
                1,
                "The count of products is wrong in the cart!!");

        double actualTotalPrice = cartPage.goToCartPage()//STEP 9 -> make sure that the total amount of all items is correct with the shipping fees if exist
                .getTotalPriceLocator();
        softAssert.assertEquals(actualTotalPrice,12900.0,"The total price is wrong!!");

        cartPage.goToSignInPage();
        signInPage.enterPhoneNumber(shippingData.getPhoneNumber())
                .enterPassword(shippingData.getPassword());

        checkOutPage.addAddress(shippingData.getFullName()//STEP 8 -> add address and choose cash as a payment method
                ,shippingData.getPhoneNumber()
                ,shippingData.getStreetName()
                ,shippingData.getBuildingName()
                ,shippingData.getCityArea()
                ,shippingData.getDistrict()
                ,shippingData.getLandMark());
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        quitDriver();
    }
}
