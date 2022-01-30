package pages;


import elements.LightningFormattedElement;
import enums.Industry;
import enums.LeadSource;
import enums.LeadStatus;
import enums.Rating;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Leads;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LeadsDetailsPage extends BasePage {

    private static final By BUTTON_STATUS_COMPLETE = By.xpath("//button[contains(@class,'slds-button--brand')]//span[text()='Mark Status as Complete']");
    private static final By BUTTON_CONVERT = By.xpath("//span[text()='Convert']");
    private String CREATED_LEADS_MESSAGE = "//span[text()='Your lead has been converted']";
    private String INPUT_ACCOUNT_NAME = "//span[text()='Account Name']";


    public LeadsDetailsPage(WebDriver driver) {
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

    public Leads getLeadsDetailsInfo() {

        Leads leads = Leads.builder().build();

        log.info("get text salutation");
        LeadStatus leadsLeadStatus = LeadStatus.fromString(new LightningFormattedElement(driver, "Lead Status").getText());
        if (leadsLeadStatus != null) {
            leads.setLeadStatus(leadsLeadStatus);
        }

        log.info("get text leads name");
        String leadstName = new LightningFormattedElement(driver, "Name").getText();
        if (leadstName != "") {
            leads.setLastName(leadstName);
        }

        log.info("get text leads title");
        String leadsTitle = new LightningFormattedElement(driver, "Titel").getText();
        if (leadsTitle != "") {
            leads.setTitle(leadsTitle);
        }

        log.info("get text leads email");
        String leadsEmail = new LightningFormattedElement(driver, "Email").getText();
        if (leadsEmail != "") {
            leads.setEmail(leadsEmail);
        }

        log.info("get text leads phone");
        String leadsPhone = new LightningFormattedElement(driver, "Phone").getText();
        if (leadsPhone != "") {
            leads.setPhone(leadsPhone);
        }

        log.info("get text leads mobile");
        String leadsMobile = new LightningFormattedElement(driver, "Mobile").getText();
        if (leadsMobile != "") {
            leads.setMobile(leadsMobile);
        }


        log.info("get text rating");
        Rating leadsRating = Rating.fromString(new LightningFormattedElement(driver, "Rating").getText());
        if (leadsRating != null) {
            leads.setRating(leadsRating);
        }


        log.info("get text leads website");
        String leadsWebsite = new LightningFormattedElement(driver, "Website").getText();
        if (leadsWebsite != "") {
            leads.setWebsite(leadsWebsite);
        }

        log.info("get text leads company");
        String leadsCompany = new LightningFormattedElement(driver, "Company").getText();
        if (leadsCompany != "") {
            leads.setCompany(leadsCompany);
        }

        log.info("get text leads industry");
        Industry leadsIndustry = Industry.fromString(new LightningFormattedElement(driver, "Company").getText());
        if (leadsIndustry != null) {
            leads.setIndustry(leadsIndustry);
        }

        log.info("get text leads No. of Employee");
        String leadsNoOfEmployee = new LightningFormattedElement(driver, "No. of Employee").getText();
        if (leadsNoOfEmployee != null) {
            leads.setNumberOfEmployee(leadsNoOfEmployee);
        }

        log.info("get text leads Lead Source");
        LeadSource leadsLeadSource = LeadSource.fromString(new LightningFormattedElement(driver, "Lead Source").getText());
        if (leadsLeadSource != null) {
            leads.setLeadSource(leadsLeadSource);
        }

        log.info("get text leads address");
        String leadsAddress = new LightningFormattedElement(driver, "Address").getText();
        if (leadsAddress != "") {
            leads.setSearchAddress(leadsAddress);
        }

        return leads;

    }
    @Step("Click button 'status'")
    public void clickButtonStatus() {
        log.info("clicking button status complete");
        jsClick(driver.findElement(BUTTON_STATUS_COMPLETE));
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_STATUS_COMPLETE));
    }

    @Step("Click button 'convert'")
    public LeadsDetailsPage clickConvertButton() {
        log.info("click convert button on leads modal");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_ACCOUNT_NAME)));
        driver.findElement(BUTTON_CONVERT).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATED_LEADS_MESSAGE)));
        return this;
    }

    @Step("verify notification message what 'leads' was created")
    public WebElement verifyNotificationMessage() {
        log.info("wait notification message ");
        WebElement createdLeadsMessage = driver.findElement(By.xpath(CREATED_LEADS_MESSAGE));
        return createdLeadsMessage;

    }

}
