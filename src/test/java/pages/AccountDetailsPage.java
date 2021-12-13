package pages;

import elements.LightningFormattedAddressElement;
import elements.LightningFormattedElement;
import enums.AccountIndustry;
import enums.AccountType;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AccountDetailsPage extends BasePage {

    private final static By TEXT_ELEMENT_DETAIL = By.xpath("//a[text()='Details']");
    private final static By BUTTON_FUTTER_PAGE = By.xpath("//button[contains(@class,'uiButton')]/span[text()='Show All Activities']");

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
        Account account = Account.builder().build();
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        if (accountName != "") {
            account.setAccountName(accountName);
        }
        String accountPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (accountPhone != "") {
            account.setPhone(accountPhone);
        }
        String parentAccount = new LightningFormattedElement(driver, "Parent Account").getText();
        if (parentAccount != "") {
            account.setParentAccount(parentAccount);
        }
        String accountFax = new LightningFormattedElement(driver, "Fax").getText();
        if (accountFax != "") {
            account.setFax(accountFax);
        }
        String accountWebsite = new LightningFormattedElement(driver, "Website").getText();
        if (accountWebsite != "") {
            account.setWebsite(accountWebsite);
        }
        AccountType accountType = AccountType.fromString(new LightningFormattedElement(driver, "Type").getText());
        if (accountType != null) {
            account.setType(accountType);
        }
        AccountIndustry accountIndustry = AccountIndustry.fromString(new LightningFormattedElement(driver, "Type").getText());
        if (accountIndustry != null) {
            account.setIndustry(accountIndustry);
        }
        String accountEmployees = new LightningFormattedElement(driver, "Employees").getText();
        if (accountEmployees != "") {
            account.setEmployees(accountEmployees);
        }
        String accountAnnualRevenue = new LightningFormattedElement(driver, "Annual Revenue").getText();
        if (accountAnnualRevenue != "") {
            account.setAnnualRevenue(accountAnnualRevenue);
        }
        String accountShippingAddress = new LightningFormattedAddressElement(driver, "Shipping Address").getText();
        if (accountShippingAddress != "") {
            account.setShippingAddress(accountShippingAddress);
        }
        String accountBillingAddress = new LightningFormattedAddressElement(driver, "Billing Address").getText();
        if (accountBillingAddress != "") {
            account.setBillingAddress(accountBillingAddress);
        }
        String accountDescription = new LightningFormattedElement(driver, "Description").getText();
        if (accountDescription != "") {
            account.setDescription(accountDescription);
        }
        return account;

        //account.setBillingStreet(new LightningFormattedElementTextArea(driver, "Billing Street").getText());
        // account.setShippingStreet(new LightningFormattedElementTextArea(driver, "Shipping Street").getText());
        //account.setBillingCity(new LightningFormattedElementTextArea(driver, "Billing City").getText());
        //account.setShippingCity(new LightningFormattedElementTextArea(driver, "Shipping City").getText());
        //account.setBillingStateProvince(new LightningFormattedElementTextArea(driver, "Billing State/Province").getText());
        //account.setShippingStateProvince(new LightningFormattedElementTextArea(driver, "Shipping State/Province").getText());
        //account.setBillingZipPostalCode(new LightningFormattedElementTextArea(driver, "Billing Zip/Postal Code").getText());
        //account.setShippingZipPostalCode(new LightningFormattedElementTextArea(driver, "Shipping Zip/Postal Code").getText());
        //account.setBillingCountry(new LightningFormattedElementTextArea(driver, "Billing Country").getText());
        //account.setShippingCountry(new LightningFormattedElementTextArea(driver, "Shipping Country").getText());


    }


    public void waitUntilDetailsLabelVisible(WebElement element) {
        waitUntilDetailsLabelVisible(driver.findElement(TEXT_ELEMENT_DETAIL));
    }
}
