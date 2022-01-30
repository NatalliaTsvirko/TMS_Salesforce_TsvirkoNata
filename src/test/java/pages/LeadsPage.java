package pages;

import io.qameta.allure.Step;
import modals.LeadsModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeadsPage extends BasePage {

    final By NEW_BUTTON = By.cssSelector("a[title=New]");
    final By DETAILS_TAB = By.xpath("//div[contains(@class,'active')]//*[@id='detailTab__item']");
    final By SUCCESS_MESSAGE = By.xpath("//div[@class='forceVisualMessageQueue']//*[contains(@class,'slds-theme--succes')]");

    public LeadsPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public LeadsPage open() {
        driver.get(BASE_URL + "/lightning/o/Contact/list");
        return this;
    }

    @Step("Click 'new' button on lead page")
    public LeadsModal clickNewButton() {
        log.info("open contacts modal");
        driver.findElement(NEW_BUTTON).click();
        return new LeadsModal(driver);
    }

    @Step("Open detail tab after created lead ")
    public LeadsDetailsPage openDetailsTab() {
        log.info("open details lead table");
        driver.findElement(DETAILS_TAB).click();
        return new LeadsDetailsPage(driver);
    }

    @Step("Verify notification message 'lead is created' ")
    public boolean verifyNotificationMessage() {
        log.info("wait notification message ");
        WebElement successMessage = driver.findElement(SUCCESS_MESSAGE);
        return successMessage.isDisplayed();
    }
}
