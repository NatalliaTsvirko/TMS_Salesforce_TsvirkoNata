package tests;


import com.github.javafaker.Faker;
import enums.AccountIndustry;
import enums.AccountType;
import modals.AccountModal;
import models.Account;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountDetailsPage;
import pages.AccountsPage;
import pages.HomePage;
import utils.AccountsGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateAccountTest extends BaseTest {

    HomePage homePage;
    AccountsPage accountsPage;
    AccountDetailsPage accountDetailsPage;
    AccountModal accountModal;
    Account testAccount;
    AccountsGenerator accountsGenerator;


    @BeforeClass
    public void initializePages() {
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
        accountModal = new AccountModal(driver);
        accountsGenerator = new AccountsGenerator();
    }

    @Test
    public void createAccountWithAllData() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.error("error");
        log.fatal("fatal");

        Faker faker = new Faker();
        testAccount = Account.builder()
                .accountName(faker.name().firstName())
                .phone("+3453455435435")
                .parentAccount("My Account")
                .fax("fax")
                .website("website")
                .type(AccountType.CUSTOMER)
                .industry(AccountIndustry.UTILITIES)
                .employees("885")
                .annualRevenue("$556")
                .billingStreet("A")
                .shippingStreet("k")
                .billingCity("City")
                .shippingCity("ShipCity")
                .billingStateProvince("3365")
                .shippingStateProvince("33256")
                .billingZipPostalCode("33254")
                .shippingZipPostalCode("55487")
                .billingCountry("Country")
                .shippingCountry("SCountry")
                .description("Hello")
                .build();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickAccountMenuLink()
                .clickNewButton()
                .fillForm(testAccount)
                .clickSaveButton();
        accountsPage.veryfiNotificationMessage();
        Account actualAccountDetailsInfo = accountsPage.openDetailsTab()
                .getAccountDetailsInfo();
        assertEquals(actualAccountDetailsInfo, testAccount, "Account details don't match test account data");
    }

    @Test
    public void createAccountWithAccountName() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.error("error");
        log.fatal("fatal");

        Faker faker = new Faker();
        testAccount = Account.builder()
                .accountName(faker.name().firstName())
                .build();
        boolean isloggedIn = loginPage.open().login(USERNAME, PASSWORD).isPageOpened();
        assertTrue(isloggedIn);
        homePage.clickAccountMenuLink()
                .clickNewButton()
                .fillForm(testAccount)
                .clickSaveButton();
        accountsPage.veryfiNotificationMessage();
        Account actualAccountDetailsInfo = accountsPage.openDetailsTab()
                .getAccountDetailsInfo();
        assertEquals(actualAccountDetailsInfo, testAccount, "Account details don't match test account data");
    }

}