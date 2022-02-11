package pages;

import modals.ContactsModal;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactsPage extends  BasePage{
    final By NEW_BUTTON = By.cssSelector("a[title=New]");
    final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");
    final By SUCCESS_MESSAGE = By.xpath("//div[@class='forceVisualMessageQueue']//*[contains(@class,'slds-theme--succes')]");



    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public ContactsPage open() {
        driver.get(BASE_URL + "lightning/o/Contact/list?filterName=Recent");
        return this;
    }

    public ContactsModal clickNewButton() {
        driver.findElement(NEW_BUTTON).click();
        log.info("open contacts modal");
        return new ContactsModal(driver);
    }

    public ContactDetailsPage openDetailsTab() {
        driver.findElement(DETAILS_TAB).click();
        log.info("open details contacts table");
        return new ContactDetailsPage(driver);
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
