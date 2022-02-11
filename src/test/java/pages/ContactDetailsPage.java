package pages;

import elements.LightningFormattedAddressElement;
import elements.LightningFormattedElement;
import enums.ContactsLeadSource;
import enums.ContactsSalutation;
import models.Contacts;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage extends BasePage {

    public ContactDetailsPage(WebDriver driver) {
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

    public Contacts getContactsDetailsInfo() {

        Contacts contacts = Contacts.builder().build();

        ContactsSalutation contactsSalutation = ContactsSalutation.fromString(new LightningFormattedElement(driver, "Salutation").getText());
        if (contactsSalutation != null) {
            contacts.setSalutation(contactsSalutation);
        }
        log.info("get text salutation");

        String contactName = new LightningFormattedElement(driver, "Name").getText();
        if (contactName != "") {
            contacts.setFirstName(contactName);
        }
        log.info("get text contact name");

        String contactsAccountName = new LightningFormattedElement(driver, "Account Name").getText();
        if (contactsAccountName != "") {
            contacts.setAccountName(contactsAccountName);
        }
        log.info("get text contacts account name");

        String contactsTitle = new LightningFormattedElement(driver, "Titel").getText();
        if (contactsTitle != "") {
            contacts.setTitle(contactsTitle);
        }
        log.info("get text contacts title");

        String contactsPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (contactsPhone != "") {
            contacts.setPhone(contactsPhone);
        }
        log.info("get text contacts phone");

        String contactsMobile = new LightningFormattedElement(driver, "Mobile").getText();
        if (contactsMobile != "") {
            contacts.setMobile(contactsMobile);
        }
        log.info("get text contacts mobile");

        String contactsEmail = new LightningFormattedElement(driver, "Email").getText();
        if (contactsEmail != null) {
            contacts.setEmail(contactsEmail);
        }
        log.info("get text contacts email");

        String contactsReportsTo = new LightningFormattedElement(driver, "Reports To").getText();
        if (contactsReportsTo != null) {
            contacts.setReportsTo(contactsReportsTo);
        }
        log.info("get text reports to");


        String contactsFax = new LightningFormattedElement(driver, "Fax").getText();
        if (contactsFax != "") {
            contacts.setFax(contactsFax);
        }
        log.info("get text contacts fax");

        String contactsHomePhone = new LightningFormattedAddressElement(driver, "Home Phone").getText();
        if (contactsHomePhone != "") {
            contacts.setHomePhone(contactsHomePhone);
        }
        log.info("get text contacts home phone");

        String contactOtherPhone = new LightningFormattedAddressElement(driver, "Other Phone").getText();
        if (contactOtherPhone != "") {
            contacts.setOtherPhone(contactOtherPhone);
        }
        log.info("get text contacts other phone");

        String contactsAsstPhone = new LightningFormattedElement(driver, "Asst. Phone").getText();
        if (contactsAsstPhone != "") {
            contacts.setAsstPhone(contactsAsstPhone);
        }
        log.info("get text contacts asst. phone");

        String contactsAssistant = new LightningFormattedElement(driver, "Assistant").getText();
        if (contactsAssistant != "") {
            contacts.setAssistant(contactsAssistant);
        }
        log.info("get text contacts assistant");
        String contactsDescription = new LightningFormattedElement(driver, "Description").getText();
        if (contactsDescription != "") {
            contacts.setDescription(contactsDescription);
        }
        log.info("get text contacts description");

        ContactsLeadSource contactsLeadSource = ContactsLeadSource.fromString(new LightningFormattedElement(driver, "Lead Source").getText());
        if (contactsLeadSource != null) {
            contacts.setLeadSource(contactsLeadSource);
        }
        log.info("get text contacts lead source");


        String contactsBirthdate = new LightningFormattedElement(driver, "Birthdate").getText();
        if (contactsBirthdate != "") {
            contacts.setBirthdate(contactsBirthdate);
        }
        log.info("get text contacts birthdate");

        return contacts;

    }
}
