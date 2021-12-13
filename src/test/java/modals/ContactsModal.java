package modals;

import elements.DropdownContactsElement;
import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContactsPage;

public class ContactsModal extends BaseModal {

    final static By SAVE_BUTTON = By.xpath("//*[@title='Save']");
    private final static By TEXT_ACCOUNT_INFORMATIONS = By.xpath("//span[text()='Account Information']");
    private static final By ACCOUNT_NAME = By.xpath("//input[@placeholder='Search Accounts...']");
    private static final By OPTIONS_DROPDOWN = By.xpath("//input[@placeholder='%s']");
    private static final By TITLE = By.xpath("//input[@name='Title']");
    private static final By FIRST_NAME = By.xpath("//input[@name='firstName']");
    private static final By LAST_NAME = By.xpath("//input[@name='lastName']");
    private static final By PHONE = By.xpath("//input[@name='Phone']");
    private static final By MOBILE_PHONE = By.xpath("//input[@name='MobilePhone']");
    private static final By EMAIL = By.xpath("//input[@name='Email']");
    private static final By REPORTS_TO = By.xpath("//input[@placeholder='Search Contacts...']");
    private static final By MAILING_CITY = By.xpath("//input[@name='city']/preceding::label[text()='Mailing City']");
    private static final By MAILING_PROVINCE = By.xpath("//input[@name='province']/preceding::label[text()='Mailing State/Province']");
    private static final By OTHER_CITY = By.xpath("//label[text()='Other City']/following::input[@name='city']");
    private static final By OTHER_PROVINCE = By.xpath("//input[@name='province']/preceding::label[text()='Other State/Province']");
    private static final By MAILING_ZIP = By.xpath("//input[@name='postalCode']/preceding::label[text()='Mailing Zip/Postal Code']");
    private static final By MAILING_COUNTRY = By.xpath("//input[@name='country']/preceding::label[text()='Mailing Country']");
    private static final By OTHER_ZIP = By.xpath("//input[@name='postalCode']/preceding::label[text()='Other Zip/Postal Code']");
    private static final By OTHER_COUNTRY = By.xpath("//input[@name='country']/preceding::label[text()='Other Country']");
    private static final By FAX = By.xpath("//input[@name='Fax']");
    private static final By HOME_PHONE = By.xpath("//input[@name='HomePhone']");
    private static final By OTHER_PHONE = By.xpath("//input[@name='OtherPhone']");
    private static final By ASSIST_PHONE = By.xpath("//input[@name='AssistantPhone']");
    private static final By ASSIST_NAME = By.xpath("//input[@name='AssistantName']");
    private static final By DEPARTMENT = By.xpath("//input[@name='Department']");
    private static final By BIRTHDATE = By.xpath("//input[@name='Birthdate']");
    private static final By MAILING_STREET = By.xpath("//label[text()='Mailing Street']/ancestor::lightning-textarea//textarea[@name='street']");
    private static final By OTHER_STREET = By.xpath("//label[text()='Other Street']/ancestor::lightning-textarea//textarea[@name='street']");
    private static final By DESCRIPTION = By.xpath("//label[text()='Description']/ancestor::lightning-textarea//textarea");

    public ContactsModal(WebDriver driver) {
        super(driver);
    }

    public ContactsModal fillForm(Contacts contacts) {

        if (contacts.getSalutation() != null) {
            new DropdownContactsElement(driver, "Salutation").selectOption(contacts.getSalutation().getName());
        }
        if (contacts.getFirstName() != null) {
            driver.findElement(FIRST_NAME).sendKeys(contacts.getFirstName());
        }

        if (contacts.getLastName() != null) {
            driver.findElement(LAST_NAME).sendKeys(contacts.getLastName());
        }

        if (contacts.getAccountName() != null) {
            driver.findElement(ACCOUNT_NAME).sendKeys(contacts.getAccountName());
        }

        if (contacts.getTitle() != null) {
            driver.findElement(TITLE).sendKeys(contacts.getTitle());
        }

        if (contacts.getPhone() != null) {
           driver.findElement(PHONE).sendKeys(contacts.getPhone());
        }

        if (contacts.getMobile() != null) {
            driver.findElement(MOBILE_PHONE).sendKeys(contacts.getMobile());
        }

        if (contacts.getEmail() != null) {
            driver.findElement(EMAIL).sendKeys(contacts.getEmail());
        }

        if (contacts.getReportsTo() != null) {
            driver.findElement(REPORTS_TO).sendKeys(contacts.getReportsTo());
        }

        if (contacts.getMailingStreet() != null) {
            driver.findElement(MAILING_STREET).sendKeys(contacts.getMailingStreet());
        }

        if (contacts.getMailingCity() != null) {
            driver.findElement(MAILING_CITY).sendKeys(contacts.getMailingCity());
        }

        if (contacts.getMailingStateProvince() != null) {
            driver.findElement(MAILING_PROVINCE).sendKeys(contacts.getMailingStateProvince());
        }

        if (contacts.getMailingZipPostalCode() != null) {
          driver.findElement(MAILING_ZIP).sendKeys(contacts.getMailingZipPostalCode());
        }

        if (contacts.getMailingCountry() != null) {
            driver.findElement(MAILING_COUNTRY).sendKeys(contacts.getMailingCountry());
        }

        if (contacts.getOtherStreet() != null) {
            driver.findElement(OTHER_STREET).sendKeys(contacts.getOtherStreet());
        }

        if (contacts.getOtherCity() != null) {
            driver.findElement(OTHER_CITY).sendKeys(contacts.getOtherCity());
        }

        if (contacts.getOtherStateProvince() != null) {
            driver.findElement(OTHER_PROVINCE).sendKeys(contacts.getOtherStateProvince());
        }

        if (contacts.getOtherZipPostalCode() != null) {
           driver.findElement(OTHER_ZIP).sendKeys(contacts.getOtherZipPostalCode());
        }

        if (contacts.getOtherCountry() != null) {
            driver.findElement(OTHER_COUNTRY).sendKeys(contacts.getOtherCountry());
        }

        if (contacts.getFax() != null) {
            driver.findElement(FAX).sendKeys(contacts.getFax());
        }

        if (contacts.getHomePhone() != null) {
            driver.findElement(HOME_PHONE).sendKeys(contacts.getHomePhone());
        }

        if (contacts.getOtherPhone() != null) {
            driver.findElement(OTHER_PHONE).sendKeys(contacts.getOtherPhone());
        }

        if (contacts.getAsstPhone() != null) {
            driver.findElement(ASSIST_PHONE).sendKeys(contacts.getAsstPhone());
        }

        if (contacts.getAssistant() != null) {
            driver.findElement(ASSIST_NAME).sendKeys(contacts.getAssistant());
        }

        if (contacts.getDepartment() != null) {
            driver.findElement(DEPARTMENT).sendKeys(contacts.getDepartment());
        }

        if (contacts.getLeadSource() != null) {
            new DropdownContactsElement(driver, "Lead Source").selectOption(contacts.getLeadSource().getName());
        }

        if (contacts.getBirthdate() != null) {
            driver.findElement(BIRTHDATE).sendKeys(contacts.getBirthdate());
        }

        if (contacts.getDescription() != null) {
           driver.findElement(DESCRIPTION).sendKeys(contacts.getDescription());
        }
        return this;
    }

    public ContactsPage clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
        return new ContactsPage(driver);
    }

    public void waitUntilElementVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_ACCOUNT_INFORMATIONS));
    }

    public void openAccountNameFilter(int index) {
        driver.findElement(ACCOUNT_NAME).click();
        Select dropdownFilter = new Select(driver.findElement(OPTIONS_DROPDOWN));
        dropdownFilter.selectByIndex(index);

    }


}
