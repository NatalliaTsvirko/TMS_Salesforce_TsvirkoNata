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

        if(account.getPhone()!= null){
            new Input(driver, "Phone").write(account.getPhone());
        }

        if(account.getParentAccount()!= null){
            new Input(driver, "Parent Account").write(account.getParentAccount());
        }

        if(account.getFax()!= null){
            new Input(driver, "Fax").write(account.getFax());
        }

        if(account.getWebsite()!= null){
            new Input(driver, "Website").write(account.getWebsite());
        }

        if(account.getType()!= null){
            new Dropdown(driver, "Type").selectOption(account.getType().getName());
        }

        if(account.getIndustry()!= null){
            new Dropdown(driver, "Industry").selectOption(account.getIndustry().getName());
        }

        if(account.getEmployees()!= null){
            new Input(driver, "Employees").write(account.getEmployees());
        }

        if(account.getAnnualRevenue()!= null){
            new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        }

        if(account.getDescription()!= null){
            new TextArea(driver, "Description").write(account.getDescription());
        }

        if(account.getBillingStreet()!= null){
            new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        }

        if(account.getShippingStreet()!= null){
            new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        }

        if(account.getBillingCity()!= null){
            new Input(driver, "Billing City").write(account.getBillingCity());
        }

        if(account.getShippingCity()!= null){
            new Input(driver, "Shipping City").write(account.getShippingCity());
        }

        if(account.getBillingStateProvince()!= null){
            new Input(driver, "Billing State/Province").write(account.getBillingStateProvince());
        }

        if(account.getShippingStateProvince()!= null){
            new Input(driver, "Shipping State/Province").write(account.getShippingStateProvince());
        }

        if(account.getBillingZipPostalCode()!= null){
            new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZipPostalCode());
        }

        if(account.getShippingZipPostalCode()!= null){
            new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZipPostalCode());
        }

        if(account.getBillingCountry()!= null){
            new Input(driver, "Billing Country").write(account.getBillingCountry());
        }

        if(account.getShippingCountry()!= null){
            new Input(driver, "Shipping Country").write(account.getShippingCountry());
        }
        return this;
    }

    public AccountsPage clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
        return new AccountsPage(driver);
    }

    public void waitUntilElementVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_ACCOUNT_INFORMATIONS));
    }

}


