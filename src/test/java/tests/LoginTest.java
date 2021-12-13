package tests;

import modals.AccountModal;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.HomePage;


import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void positiveLogin(){
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.error("error");
        log.fatal("fatal");

        boolean isLoggedIn = loginPage.open().login(USERNAME,PASSWORD).isPageOpened();
        assertTrue(isLoggedIn);
    }

//Work on lecture
    @Test
    public void positiveLoginSecond(){
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.error("error");
        log.fatal("fatal");

        boolean isLoggedIn = loginPage.open().login(USERNAME,PASSWORD).isPageOpened();
        assertTrue(isLoggedIn);
        HomePage homePage = new HomePage(driver);
        homePage.clickAccountMenuLink();
        AccountsPage accountsPage = new AccountsPage(driver);
        accountsPage.clickNewButton();
        AccountModal accountModal = new AccountModal(driver);
        accountModal.clickSaveButton();
    }
}
