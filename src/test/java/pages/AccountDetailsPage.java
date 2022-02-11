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
        log.info("get text account name");

        String accountPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (accountPhone != "") {
            account.setPhone(accountPhone);
        }
        log.info("get text phone");

        String parentAccount = new LightningFormattedElement(driver, "Parent Account").getText();
        if (parentAccount != "") {
            account.setParentAccount(parentAccount);
        }
        log.info("get text parent account");

        String accountFax = new LightningFormattedElement(driver, "Fax").getText();
        if (accountFax != "") {
            account.setFax(accountFax);
        }
        log.info("get text fax");

        String accountWebsite = new LightningFormattedElement(driver, "Website").getText();
        if (accountWebsite != "") {
            account.setWebsite(accountWebsite);
        }
        log.info("get text website");

        AccountType accountType = AccountType.fromString(new LightningFormattedElement(driver, "Type").getText());
        if (accountType != null) {
            account.setType(accountType);
        }
        log.info("get text account type");

        AccountIndustry accountIndustry = AccountIndustry.fromString(new LightningFormattedElement(driver, "Type").getText());
        if (accountIndustry != null) {
            account.setIndustry(accountIndustry);
        }
        log.info("get text account industry");

        String accountEmployees = new LightningFormattedElement(driver, "Employees").getText();
        if (accountEmployees != "") {
            account.setEmployees(accountEmployees);
        }
        log.info("get text account employee");

        String accountAnnualRevenue = new LightningFormattedElement(driver, "Annual Revenue").getText();
        if (accountAnnualRevenue != "") {
            account.setAnnualRevenue(accountAnnualRevenue);
        }
        log.info("get text annual revenue");

        String accountShippingAddress = new LightningFormattedAddressElement(driver, "Shipping Address").getText();
        if (accountShippingAddress != "") {
            account.setShippingAddress(accountShippingAddress);
        }
        log.info("get text shipping address");

        String accountBillingAddress = new LightningFormattedAddressElement(driver, "Billing Address").getText();
        if (accountBillingAddress != "") {
            account.setBillingAddress(accountBillingAddress);
        }
        log.info("get text billing address");

        String accountDescription = new LightningFormattedElement(driver, "Description").getText();
        if (accountDescription != "") {
            account.setDescription(accountDescription);
        }
        log.info("get text description");
        return account;

    }

    public void waitUntilDetailsLabelVisible(WebElement element) {
        waitUntilDetailsLabelVisible(driver.findElement(TEXT_ELEMENT_DETAIL));
    }
}
