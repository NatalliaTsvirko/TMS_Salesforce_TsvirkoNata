package pages;

import modals.AccountModal;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class AccountsPage extends BasePage {

    final By NEW_BUTTON = By.cssSelector("a[title=New]");
    final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");
    final By SUCCESS_MESSAGE = By.xpath("//div[@class='forceVisualMessageQueue']//*[contains(@class,'slds-theme--succes')]");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public AccountsPage open() {
        driver.get(BASE_URL + "/lightning/r/Account/0015j00000B1kO5AAJ/view");
        return this;
    }

    public AccountModal clickNewButton() {
        driver.findElement(NEW_BUTTON).click();
        log.info("open account modal");
        return new AccountModal(driver);
    }

    public AccountDetailsPage openDetailsTab() {
        driver.findElement(DETAILS_TAB).click();
        log.info("open details table");
        return new AccountDetailsPage(driver);
    }

    public boolean veryfiNotificationMessage() {
        WebElement successMessage = driver.findElement(SUCCESS_MESSAGE);
        log.info("wait notification message ");
        return successMessage.isDisplayed();
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

