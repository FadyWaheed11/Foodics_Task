package ui.pages;

import org.openqa.selenium.By;

import static ui.utils.SharedSteps.clickOnElement;
import static ui.utils.SharedSteps.sendTextToElement;

public class SignInPage {
    private final By phoneNumberFieldLocator = By.xpath("//input[@name='email']");
    private final By continueButtonLocator = By.id("continue");
    private final By passwordFieldLocator = By.id("ap_password");
    private final By signInFieldLocator = By.id("signInSubmit");

    //prevent instance
    private SignInPage() {
    }

    public static SignInPage getSignInPage() {
        return new SignInPage();
    }

    public SignInPage enterPhoneNumber(String phoneNumber) {
        sendTextToElement(phoneNumberFieldLocator, phoneNumber);
        clickOnElement(continueButtonLocator);
        return this;
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordFieldLocator, password);
        clickOnElement(signInFieldLocator);
    }

}
