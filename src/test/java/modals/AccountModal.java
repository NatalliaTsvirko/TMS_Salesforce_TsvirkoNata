package modals;

import elements.Dropdown;
import elements.Input;
import elements.TextArea;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountsPage;


public class AccountModal extends BaseModal {

    final static By SAVE_BUTTON = By.xpath("//*[@title='Save']");
    private final static By TEXT_ACCOUNT_INFORMATIONS = By.xpath("//span[text()='Account Information']");

    public AccountModal(WebDriver driver) {
        super(driver);
    }

    public AccountModal fillForm(Account account) {

        if(account.getAccountName()!= null){
            new Input(driver, "Account Name").write(account.getAccountName());
        }
        log.info("write account name");

        if(account.getPhone()!= null){
            new Input(driver, "Phone").write(account.getPhone());
        }
        log.info("write account phone");
        if(account.getParentAccount()!= null){
            new Input(driver, "Parent Account").write(account.getParentAccount());
        }
        log.info("write parent account");

        if(account.getFax()!= null){
            new Input(driver, "Fax").write(account.getFax());
        }
        log.info("write account fax");

        if(account.getWebsite()!= null){
            new Input(driver, "Website").write(account.getWebsite());
        }
        log.info("write account website");

        if(account.getType()!= null){
            new Dropdown(driver, "Type").selectOption(account.getType().getName());
        }
        log.info("select account type");

        if(account.getIndustry()!= null){
            new Dropdown(driver, "Industry").selectOption(account.getIndustry().getName());
        }
        log.info("select account industry");

        if(account.getEmployees()!= null){
            new Input(driver, "Employees").write(account.getEmployees());
        }
        log.info("write account employees");

        if(account.getAnnualRevenue()!= null){
            new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        }

        if(account.getDescription()!= null){
            new TextArea(driver, "Description").write(account.getDescription());
        }
        log.info("write account description");

        if(account.getBillingStreet()!= null){
            new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        }
        log.info("write account billing street");

        if(account.getShippingStreet()!= null){
            new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        }
        log.info("write account shipping street");

        if(account.getBillingCity()!= null){
            new Input(driver, "Billing City").write(account.getBillingCity());
        }
        log.info("write account billing city");

        if(account.getShippingCity()!= null){
            new Input(driver, "Shipping City").write(account.getShippingCity());
        }
        log.info("write account shipping city");

        if(account.getBillingStateProvince()!= null){
            new Input(driver, "Billing State/Province").write(account.getBillingStateProvince());
        }
        log.info("write account billing state/province");

        if(account.getShippingStateProvince()!= null){
            new Input(driver, "Shipping State/Province").write(account.getShippingStateProvince());
        }
        log.info("write account shipping state/province");

        if(account.getBillingZipPostalCode()!= null){
            new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZipPostalCode());
        }
        log.info("write account billing zip/postal code");

        if(account.getShippingZipPostalCode()!= null){
            new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZipPostalCode());
        }
        log.info("write account shipping zip/postal code");

        if(account.getBillingCountry()!= null){
            new Input(driver, "Billing Country").write(account.getBillingCountry());
        }
        log.info("write account billing country");

        if(account.getShippingCountry()!= null){
            new Input(driver, "Shipping Country").write(account.getShippingCountry());
        }
        log.info("write account shipping country");
        return this;
    }

    public AccountsPage clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
        log.info("click save button on accounts modal");
        return new AccountsPage(driver);
    }

    public void waitUntilElementVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_ACCOUNT_INFORMATIONS));
    }

}


