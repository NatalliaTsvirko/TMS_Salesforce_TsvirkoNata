package pages;

import elements.LightningFormattedElement;
import elements.LightningFormattedElementTextArea;
import enums.AccountIndustry;
import enums.AccountType;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountDetailsPage extends BasePage {

    private final static By TEXT_ELEMENT_DETAIL = By.xpath("//a[text()='Details']");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public BasePage open() {
        return null;
    }

    public Account getAccountDetailsInfo() {
        Account account = new Account();
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        if (accountName != "") {
            account.setAccountName(accountName);
        }
        account.setPhone(new LightningFormattedElement(driver, "Phone").getText());
        account.setParentAccount(new LightningFormattedElement(driver, "Parent Account").getText());
        account.setFax(new LightningFormattedElement(driver, "Fax").getText());
        account.setWebsite(new LightningFormattedElement(driver, "Website").getText());
        account.setType(AccountType.fromString(new LightningFormattedElement(driver, "Type").getText()));
        account.setIndustry(AccountIndustry.fromString(new LightningFormattedElement(driver, "Industry").getText()));
        account.setEmployees(new LightningFormattedElement(driver, "Employees").getText());
        account.setAnnualRevenue(new LightningFormattedElement(driver, "Annual Revenue").getText());
        account.setBillingStreet(new LightningFormattedElementTextArea(driver, "Billing Street").getText());
        account.setShippingStreet(new LightningFormattedElementTextArea(driver, "Shipping Street").getText());
        account.setBillingCity(new LightningFormattedElementTextArea(driver, "Billing City").getText());
        account.setShippingCity(new LightningFormattedElementTextArea(driver, "Shipping City").getText());
        account.setBillingStateProvince(new LightningFormattedElementTextArea(driver, "Billing State/Province").getText());
        account.setShippingStateProvince(new LightningFormattedElementTextArea(driver, "Shipping State/Province").getText());
        account.setBillingZipPostalCode(new LightningFormattedElementTextArea(driver, "Billing Zip/Postal Code").getText());
        account.setShippingZipPostalCode(new LightningFormattedElementTextArea(driver, "Shipping Zip/Postal Code").getText());
        account.setBillingCountry(new LightningFormattedElementTextArea(driver, "Billing Country").getText());
        account.setShippingCountry(new LightningFormattedElementTextArea(driver, "Shipping Country").getText());
        account.setDescription(new LightningFormattedElementTextArea(driver, "Description").getText());
        return account;
    }

    public void waitUntilElementVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_ELEMENT_DETAIL));
    }

}
