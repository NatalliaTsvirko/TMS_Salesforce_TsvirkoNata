package tests;

import com.github.javafaker.Faker;
import modals.ContactsModal;
import models.Contacts;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactDetailsPage;
import pages.ContactsPage;
import pages.HomePage;
import utils.ContactsGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateContactTest extends BaseTest {

    HomePage homePage;
    ContactsPage contactsPage;
    ContactDetailsPage contactDetailsPage;
    ContactsModal contactsModal;
    Contacts testContacts;
    ContactsGenerator contactsGenerator;


    @BeforeClass
    public void initializePages() {
        homePage = new HomePage(driver);
        contactsPage = new ContactsPage(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
        contactsModal = new ContactsModal(driver);
        contactsGenerator = new ContactsGenerator();
    }

    @Test
    public void createContactWithAllData() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.error("error");
        log.fatal("fatal");

        Faker faker = new Faker();
        testContacts = Contacts.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .accountName(contactsModal.openAccountNameFilter("Kaili"))
                .title("yyyy")
                .phone(faker.phoneNumber().cellPhone())
                .mobile(faker.phoneNumber().cellPhone())
                .email("luyfiytd@mail.ru")
                .reportsTo("")
                .mailingStreet("uuu")
                .otherStreet("lll")
                .fax("j")
                .homePhone("jjj555")
                .otherPhone("65665")
                .asstPhone("liuguy")
                .assistant("hhh")
                .department("kkhj")
                .birthdate("22.1.1999")
                .description("hi")
                .build();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickContactsMenuLink()
                .clickNewButton()
                .fillForm(testContacts)
                .clickSaveButton();
        contactsPage.veryfiNotificationMessage();
        Contacts actualContactsDetailsInfo = contactsPage.openDetailsTab()
                .getContactsDetailsInfo();
        assertEquals(actualContactsDetailsInfo, testContacts, "Account details don't match test account data");
    }

}
