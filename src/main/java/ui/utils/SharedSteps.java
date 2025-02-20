package ui.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import static ui.utils.DriverFactory.getDriver;
import static ui.utils.Settings.browserType;

public final class SharedSteps {

    private static final WebDriver driver = getDriver(browserType);

    public static void goToUrl(String url) {
        driver.get(url);
    }

    private static Wait<WebDriver> getFluentWait() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    public static void clickOnElement(By elementPath) {
        WebElement element = getFluentWait().until(ExpectedConditions.elementToBeClickable(elementPath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public static void sendTextToElement(By elementPath, String text) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementPath)).sendKeys(text);
    }

    public static void maximizeScreen(){
        driver.manage().window().maximize();
    }

    public static String getElementText(By elementPath){
        return getFluentWait().until(ExpectedConditions.visibilityOfElementLocated(elementPath)).getText();
    }

    public static List<WebElement> getAllElements(By elementPath){
        return getFluentWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementPath));
    }


    public static void selectFromDropdownByIndex(By dropdownLocator, int index) {
        WebElement dropdown = getFluentWait().until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", dropdown);

        try {
            Select select = new Select(dropdown);
            select.selectByIndex(index);
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].selectedIndex=arguments[1];", dropdown, index);
        }
    }
}
