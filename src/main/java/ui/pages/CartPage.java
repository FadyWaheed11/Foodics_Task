package ui.pages;

import org.openqa.selenium.By;

import static ui.utils.SharedSteps.clickOnElement;
import static ui.utils.SharedSteps.getElementText;

public class CartPage {

    private final By cartButtonLocator = By.id("nav-cart");
    private final By processToBuyButtonLocator = By.name("proceedToRetailCheckout");
    private final By totalPriceLocator = By.id("sc-subtotal-amount-buybox");
    //prevent instance
    private CartPage(){

    }

    public static CartPage getCartPage(){
        return new CartPage();
    }

    public CartPage goToCartPage(){
        clickOnElement(cartButtonLocator);
        return this;
    }

    public void goToSignInPage(){
        clickOnElement(processToBuyButtonLocator);
    }

    public double getTotalPriceLocator(){
        double totalPrice = Double.parseDouble(getElementText(totalPriceLocator).trim().replace(",","")
                .replace("EGP ",""));
        System.out.println(totalPrice);
        return totalPrice;
    }
}
