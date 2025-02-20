package ui.pages;

import org.openqa.selenium.By;

import static ui.utils.SharedSteps.clickOnElement;
import static ui.utils.SharedSteps.sendTextToElement;

public class CheckOutPage {


    private final By changeAddressButtonLocator = By.linkText("Change");
    private final By addNewAddressButtonLocator = By.partialLinkText("Add a new address");
    private final By fullNameFieldLocator = By.id("address-ui-widgets-enterAddressFullName");
    private final By mobileNumberFieldLocator = By.id("address-ui-widgets-enterAddressPhoneNumber");
    private final By streetNameFieldLocator = By.id("address-ui-widgets-enterAddressLine1");
    private final By buildingNameFieldLocator = By.id("address-ui-widgets-enter-building-name-or-number");
    private final By cityFieldLocator = By.id("address-ui-widgets-enterAddressCity");
    private final By districtFieldLocator = By.id("address-ui-widgets-enterAddressDistrictOrCounty");
    private final By landMarkLocator = By.id("address-ui-widgets-landmark");
    private final By homeRadioButtonLocator = By.id("address-ui-widgets-addr-details-res-radio-input");
    private final By defaultAddressCheckBoxLocator = By.id("address-ui-widgets-use-as-my-default");
    private final By addAddressLocator = By.id("address-ui-widgets-form-submit-button-announce");
    //prevent instance
    private CheckOutPage(){

    }

    public static CheckOutPage getCheckOutPage(){
        return new CheckOutPage();
    }

    public CheckOutPage addAddress(String fullName,String mobileNumber,
                                   String streetName,String buildingName,
                                   String cityName,String district,
                                   String landMark){
        clickOnElement(changeAddressButtonLocator);
        clickOnElement(addNewAddressButtonLocator);
        sendTextToElement(fullNameFieldLocator,fullName);
        sendTextToElement(mobileNumberFieldLocator,mobileNumber);
        sendTextToElement(streetNameFieldLocator,streetName);
        sendTextToElement(buildingNameFieldLocator,buildingName);
        sendTextToElement(cityFieldLocator,cityName);
        clickOnElement(districtFieldLocator);
        sendTextToElement(districtFieldLocator,district);
        sendTextToElement(landMarkLocator,landMark);
        clickOnElement(homeRadioButtonLocator);
        clickOnElement(defaultAddressCheckBoxLocator);
        clickOnElement(addAddressLocator);
        return this;
    }
}
