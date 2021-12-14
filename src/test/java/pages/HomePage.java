package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    final static By SALES_LABEL = By.xpath("//*[@title='Sales']");
    final static By ACCOUNTS_MENU_LINK = By.xpath("//*[@title='Accounts']");
    final static By CONTACTS_MENU_LINK = By.xpath("//*[@title='Contacts']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(SALES_LABEL);
    }

    @Override
    public HomePage open() {
        driver.get(BASE_URL + "/lightning/page/home");
        return this;
    }

    public AccountsPage clickAccountMenuLink() {
        jsClick(driver.findElement(ACCOUNTS_MENU_LINK));
        log.info("open account page");
        return new AccountsPage(driver);
    }

    public ContactsPage clickContactsMenuLink() {
        jsClick(driver.findElement(CONTACTS_MENU_LINK));
        log.info("open contacts page");
        return new ContactsPage(driver);
    }
}

