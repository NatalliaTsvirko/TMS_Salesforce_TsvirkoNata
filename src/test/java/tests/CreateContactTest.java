package tests;

import lombok.extern.log4j.Log4j2;
import modals.ContactsModal;
import models.Contacts;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactDetailsPage;
import pages.ContactsPage;
import pages.HomePage;
import utils.AllureUtils;
import utils.ContactsGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class CreateContactTest extends BaseTest {

    HomePage homePage;
    ContactsPage contactsPage;
    ContactDetailsPage contactDetailsPage;
    ContactsModal contactsModal;
    ContactsGenerator contactsGenerator;


    @BeforeClass
    public void initializePages() {
        homePage = new HomePage(driver);
        contactsPage = new ContactsPage(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
        contactsModal = new ContactsModal(driver);
        contactsGenerator = new ContactsGenerator();

    }

    @Test(description = "Create contact with all data", groups = {"Smoke"})
    public void createContactWithAllData() {
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickContactsMenuLink()
                .clickNewButton();
        contactsModal.selectOption("Schmeler-Rempel");
        AllureUtils.attachScreenshot(driver);
        log.info("waiting until nameAccount will be present");
        ContactsModal testContact = contactsModal
                .fillForm(contactsGenerator.getContactsWithAllData());
        contactsModal.clickSaveButton();
        AllureUtils.attachScreenshot(driver);
        contactsPage.verifyNotificationMessage();
        Contacts actualContactsDetailsInfo = contactsPage.openDetailsTab()
                .getContactsDetailsInfo();
        assertEquals(actualContactsDetailsInfo, testContact, "Contacts details don't match test account data");
    }
}
