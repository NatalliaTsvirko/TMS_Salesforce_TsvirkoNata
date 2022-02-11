package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownContactsElement extends BaseElement{
    private String dropdownLocator = "//lightning-picklist[@data-field='salutation']//input[@name='salutation']";
    private String optionLocator = "";


    public DropdownContactsElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectOption(String optionName) {
        driver.findElement(By.xpath(String.format(dropdownLocator, label))).click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(optionLocator, optionName)));
        scrollIntoView(optionToClick);
        optionToClick.click();
    }
}
