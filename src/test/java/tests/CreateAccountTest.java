package tests;

import enums.AccountIndustry;
import enums.AccountType;
import modals.AccountModal;
import models.Account;
import models.AccountBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountDetailsPage;
import pages.AccountsPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateAccountTest extends BaseTest {

    HomePage homePage;
    AccountsPage accountsPage;
    AccountDetailsPage accountDetailsPage;
    AccountModal accountModal;

    @BeforeClass
    public void initializePages() {
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
        accountModal = new AccountModal(driver);

    }

    @Test
    public void createAccountWithAllData() {
        Account testAccount;
        testAccount = new AccountBuilder()
                .withAccountName("Nat")
                .withPhone("+3453455435435")
                .withParentAccount("My Account")
                .withFax("fax")
                .withWebsite("website")
                .withType(AccountType.CUSTOMER)
                .withIndustry(AccountIndustry.UTILITIES)
                .withEmployees("885")
                .withAnnualRevenue("556")
                .withBillingStreet("A")
                .withShippingStreet("k")
                .withBillingCity("City")
                .withShippingCity("ShipCity")
                .withBillingStateProvince("3365")
                .withShippingStateProvince("33256")
                .withBillingZipPostalCode("33254")
                .withShippingZipPostalCode("55487")
                .withBillingCountry("Country")
                .withShippingCountry("SCountry")
                .withDescription("Hello")
                .build();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        boolean isHomePageOpened = homePage.open().isPageOpened();
        assertTrue(isHomePageOpened);
        homePage.clickAccountMenuLink()
                .clickNewButton();
        accountModal.waitUntilElementVisible();
        accountModal.fillForm(testAccount)
                .clickSaveButton();
        assertTrue(accountsPage.notificationMessage());
        accountDetailsPage.waitUntilElementVisible();
        Account actualAccountDetailsInfo = accountsPage.openDetailsTab()
                .getAccountDetailsInfo();
        assertEquals(actualAccountDetailsInfo, testAccount, "Account details don't match test account data");
    }
}