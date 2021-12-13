package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LightningFormattedAddressElement extends BaseElement {

    String visibleTextLocator = "//span[contains(text(), '%s') and @class='test-id__field-label']/ancestor::div[contains(@class, 'test-id__output-root')]//lightning-formatted-address[@data-output-element-id='output-field']//*[contains(@class,'slds-truncate')]";

    public LightningFormattedAddressElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        return driver.findElement(By.xpath(String.format(visibleTextLocator, label))).getText();
    }

}
