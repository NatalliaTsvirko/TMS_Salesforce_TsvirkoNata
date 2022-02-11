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
        log.info("select contacts salutation");

        if (contacts.getFirstName() != null) {
            driver.findElement(FIRST_NAME).sendKeys(contacts.getFirstName());
        }
        log.info("write contacts first name");

        if (contacts.getLastName() != null) {
            driver.findElement(LAST_NAME).sendKeys(contacts.getLastName());
        }
        log.info("write contacts last name");

        if (contacts.getAccountName() != null) {
            driver.findElement(ACCOUNT_NAME).sendKeys(contacts.getAccountName());
        }
        log.info("write contacts account name");

        if (contacts.getTitle() != null) {
            driver.findElement(TITLE).sendKeys(contacts.getTitle());
        }
        log.info("write contacts title");

        if (contacts.getPhone() != null) {
            driver.findElement(PHONE).sendKeys(contacts.getPhone());
        }
        log.info("write contacts phone");

        if (contacts.getMobile() != null) {
            driver.findElement(MOBILE_PHONE).sendKeys(contacts.getMobile());
        }
        log.info("write contacts mobile phone");

        if (contacts.getEmail() != null) {
            driver.findElement(EMAIL).sendKeys(contacts.getEmail());
        }
        log.info("write contacts email");

        if (contacts.getReportsTo() != null) {
            driver.findElement(REPORTS_TO).sendKeys(contacts.getReportsTo());
        }
        log.info("write contacts reports to");

        if (contacts.getMailingStreet() != null) {
            driver.findElement(MAILING_STREET).sendKeys(contacts.getMailingStreet());
        }
        log.info("write contacts mailing street");

        if (contacts.getMailingCity() != null) {
            driver.findElement(MAILING_CITY).sendKeys(contacts.getMailingCity());
        }
        log.info("write contacts mailing city");

        if (contacts.getMailingStateProvince() != null) {
            driver.findElement(MAILING_PROVINCE).sendKeys(contacts.getMailingStateProvince());
        }
        log.info("write contacts mailing province");

        if (contacts.getMailingZipPostalCode() != null) {
            driver.findElement(MAILING_ZIP).sendKeys(contacts.getMailingZipPostalCode());
        }
        log.info("write contacts mailing zip");

        if (contacts.getMailingCountry() != null) {
            driver.findElement(MAILING_COUNTRY).sendKeys(contacts.getMailingCountry());
        }
        log.info("write contacts mailing country");

        if (contacts.getOtherStreet() != null) {
            driver.findElement(OTHER_STREET).sendKeys(contacts.getOtherStreet());
        }
        log.info("write contacts other street");

        if (contacts.getOtherCity() != null) {
            driver.findElement(OTHER_CITY).sendKeys(contacts.getOtherCity());
        }
        log.info("write contacts other city");

        if (contacts.getOtherStateProvince() != null) {
            driver.findElement(OTHER_PROVINCE).sendKeys(contacts.getOtherStateProvince());
        }
        log.info("write contacts other province");

        if (contacts.getOtherZipPostalCode() != null) {
            driver.findElement(OTHER_ZIP).sendKeys(contacts.getOtherZipPostalCode());
        }
        log.info("write contacts other zip");

        if (contacts.getOtherCountry() != null) {
            driver.findElement(OTHER_COUNTRY).sendKeys(contacts.getOtherCountry());
        }
        log.info("write contacts other country");

        if (contacts.getFax() != null) {
            driver.findElement(FAX).sendKeys(contacts.getFax());
        }
        log.info("write contacts fax");

        if (contacts.getHomePhone() != null) {
            driver.findElement(HOME_PHONE).sendKeys(contacts.getHomePhone());
        }
        log.info("write contacts home phone");

        if (contacts.getOtherPhone() != null) {
            driver.findElement(OTHER_PHONE).sendKeys(contacts.getOtherPhone());
        }
        log.info("write contacts other phone");

        if (contacts.getAsstPhone() != null) {
            driver.findElement(ASSIST_PHONE).sendKeys(contacts.getAsstPhone());
        }
        log.info("write contacts asst. phone");

        if (contacts.getAssistant() != null) {
            driver.findElement(ASSIST_NAME).sendKeys(contacts.getAssistant());
        }
        log.info("write contacts assistant");

        if (contacts.getDepartment() != null) {
            driver.findElement(DEPARTMENT).sendKeys(contacts.getDepartment());
        }
        log.info("write contacts department");

        if (contacts.getLeadSource() != null) {
            new DropdownContactsElement(driver, "Lead Source").selectOption(contacts.getLeadSource().getName());
        }
        log.info("select contacts lead source");

        if (contacts.getBirthdate() != null) {
            driver.findElement(BIRTHDATE).sendKeys(contacts.getBirthdate());
        }
        log.info("write contacts birthdate");

        if (contacts.getDescription() != null) {
            driver.findElement(DESCRIPTION).sendKeys(contacts.getDescription());
        }
        log.info("write contacts description");
        return this;
    }

    public ContactsPage clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
        log.info("click save button on contact modal");
        return new ContactsPage(driver);
    }

    public void waitUntilElementVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_ACCOUNT_INFORMATIONS));
    }

    public String openAccountNameFilter(String text) {
        driver.findElement(ACCOUNT_NAME).click();
        Select dropdownFilter = new Select(driver.findElement(OPTIONS_DROPDOWN));
        dropdownFilter.selectByVisibleText(text);
        return text;
    }

}
