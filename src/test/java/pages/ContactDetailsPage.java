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
        String contactName = new LightningFormattedElement(driver, "Name").getText();
        if (contactName != "") {
            contacts.setFirstName(contactName);
        }
        String contactsAccountName = new LightningFormattedElement(driver, "Account Name").getText();
        if (contactsAccountName != "") {
            contacts.setAccountName(contactsAccountName);
        }
        String contactsTitle = new LightningFormattedElement(driver, "Titel").getText();
        if (contactsTitle != "") {
            contacts.setTitle(contactsTitle);
        }
        String contactsPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (contactsPhone != "") {
            contacts.setPhone(contactsPhone);
        }
        String contactsMobile = new LightningFormattedElement(driver, "Mobile").getText();
        if (contactsMobile != "") {
            contacts.setMobile(contactsMobile);
        }
        String contactsEmail = new LightningFormattedElement(driver, "Email").getText();
        if (contactsEmail != null) {
            contacts.setEmail(contactsEmail);
        }
        String contactsReportsTo = new LightningFormattedElement(driver, "Reports To").getText();
        if (contactsReportsTo != null) {
            contacts.setReportsTo(contactsReportsTo);
        }

        String contactsFax = new LightningFormattedElement(driver, "Fax").getText();
        if (contactsFax != "") {
            contacts.setFax(contactsFax);
        }
        String contactsHomePhone = new LightningFormattedAddressElement(driver, "Home Phone").getText();
        if (contactsHomePhone != "") {
            contacts.setHomePhone(contactsHomePhone);
        }
        String contactOtherPhone = new LightningFormattedAddressElement(driver, "Other Phone").getText();
        if (contactOtherPhone != "") {
            contacts.setOtherPhone(contactOtherPhone);
        }
        String contactsAsstPhone = new LightningFormattedElement(driver, "Asst. Phone").getText();
        if (contactsAsstPhone != "") {
            contacts.setAsstPhone(contactsAsstPhone);
        }

        String contactsAssistant = new LightningFormattedElement(driver, "Assistant").getText();
        if (contactsAssistant != "") {
            contacts.setAssistant(contactsAssistant);
        }
        String contactsDescription = new LightningFormattedElement(driver, "Description").getText();
        if (contactsDescription != "") {
            contacts.setDescription(contactsDescription);
        }

        ContactsLeadSource contactsLeadSource = ContactsLeadSource.fromString(new LightningFormattedElement(driver, "Lead Source").getText());
        if (contactsLeadSource != null) {
            contacts.setLeadSource(contactsLeadSource);
        }

        String contactsBirthdate = new LightningFormattedElement(driver, "Birthdate").getText();
        if (contactsBirthdate != "") {
            contacts.setBirthdate(contactsBirthdate);
        }

        return contacts;

    }
}
