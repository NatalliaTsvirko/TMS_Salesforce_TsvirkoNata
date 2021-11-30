package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea extends BaseElement {

    final String textAreaElementLocator = "//div[@role='dialog' and @aria-modal='true']//*[text()= '%s']/ancestor::div[contains(@class, 'uiInput')]//textarea";

    public TextArea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void write(String text) {
        System.out.println(String.format("Setting %s into %s input", text, label));
        driver.findElement(By
                .xpath(String.format(textAreaElementLocator, label))).sendKeys(text);
    }
}
