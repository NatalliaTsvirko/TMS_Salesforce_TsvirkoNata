package pages;

import elements.LightningFormattedElement;
import enums.AccountType;
import enums.Industry;
import lombok.extern.log4j.Log4j2;
import models.Account;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountDetailsPage extends BasePage {

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

        log.info("get text account name");
        String accountName = new LightningFormattedElement(driver, "Account Name").getText();
        if (accountName != null) {
            account.setAccountName(accountName);
        }

        log.info("get text account type");
        AccountType accountType = AccountType.fromString(new LightningFormattedElement(driver, "Type").getText());
        if (accountType != null) {
            account.setType(accountType);
        }

        log.info("get text parent account");
        String parentAccount = new LightningFormattedElement(driver, "Parent Account").getText();
        if (parentAccount != "") {
            account.setParentAccount(parentAccount);
        }

        log.info("get text website");
        String accountWebsite = new LightningFormattedElement(driver, "Website").getText();
        if (accountWebsite != "") {
            account.setWebsite(accountWebsite);
        }

        log.info("get text phone");
        String accountPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (accountPhone != "") {
            account.setPhone(accountPhone);
        }

        log.info("get text description");
        String accountDescription = new LightningFormattedElement(driver, "Description").getText();
        if (accountDescription != "") {
            account.setDescription(accountDescription);
        }

        log.info("get text account industry");
        Industry accountIndustry = Industry.fromString(new LightningFormattedElement(driver, "Type").getText());
        if (accountIndustry != null) {
            account.setIndustry(accountIndustry);
        }

        log.info("get text account employee");
        String accountEmployees = new LightningFormattedElement(driver, "Employees").getText();
        if (accountEmployees != null) {
            account.setEmployees(accountEmployees);
        }

        log.info("get text billing address");
        String accountBillingAddress = new LightningFormattedElement(driver, "Billing Address").getText();
        if (accountBillingAddress != "") {
            account.setBillingAddress(accountBillingAddress);
        }

        log.info("get text shipping address");
        String accountShippingAddress = new LightningFormattedElement(driver, "Shipping Address").getText();
        if (accountShippingAddress != "") {
            account.setShippingAddress(accountShippingAddress);
        }
        return account;

    }

}
