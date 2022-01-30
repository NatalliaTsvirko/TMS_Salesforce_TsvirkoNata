package pages;

import elements.LightningFormattedElement;
import lombok.extern.log4j.Log4j2;
import models.Contacts;
import org.openqa.selenium.WebDriver;

@Log4j2
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

        log.info("get text contact name");
        String contactName = new LightningFormattedElement(driver, "Name").getText();
        if (contactName != "") {
            contacts.setFirstName(contactName);
        }

        log.info("get text contacts account name");
        String contactsAccountName = new LightningFormattedElement(driver, "Account Name").getText();
        if (contactsAccountName != "") {
            contacts.setAccountName(contactsAccountName);
        }

        log.info("get text contacts title");
        String contactsTitle = new LightningFormattedElement(driver, "Title").getText();
        if (contactsTitle != "") {
            contacts.setTitle(contactsTitle);
        }

        log.info("get text contacts phone");
        String contactsPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (contactsPhone != "") {
            contacts.setPhone(contactsPhone);
        }

        log.info("get text contacts email");
        String contactsEmail = new LightningFormattedElement(driver, "Email").getText();
        if (contactsEmail != "") {
            contacts.setEmail(contactsEmail);
        }

        log.info("get text contacts mobile");
        String contactsMobile = new LightningFormattedElement(driver, "Mobile").getText();
        if (contactsMobile != "") {
            contacts.setMobile(contactsMobile);
        }

        log.info("get text reports to");
        String contactsReportsTo = new LightningFormattedElement(driver, "Reports To").getText();
        if (contactsReportsTo != "") {
            contacts.setReportsTo(contactsReportsTo);
        }

        log.info("get text contacts fax");
        String contactsFax = new LightningFormattedElement(driver, "Fax").getText();
        if (contactsFax != "") {
            contacts.setFax(contactsFax);
        }
        return contacts;
    }
}
