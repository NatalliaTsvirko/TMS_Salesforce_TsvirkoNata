package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LightningFormattedElementTextArea extends BaseElement {

    String visibleTextLocator = "//span[contains(text(), '') and @class='test-id__field-label']/ancestor::div[contains(@class, 'test-id__output-root')]//*[@data-output-element-id='output-field']/a[contains(text(),'')]";

    public LightningFormattedElementTextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getText() {
        return driver.findElement(By.xpath(String.format(visibleTextLocator, label))).getText();
    }
}

