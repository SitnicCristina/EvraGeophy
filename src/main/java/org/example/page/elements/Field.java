package org.example.page.elements;

import org.example.page.components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Field extends BaseComponent {

    public static final By fielLocators = By.cssSelector("input[type='text']");

    public static void enterText(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fielLocators));
        driver.findElement(fielLocators).sendKeys(text);
    }

    public WebElement getFieldByLabel(String fieldName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fielLocators));
        List<WebElement> fields = driver.findElements(fielLocators);

        for (WebElement field : fields) {
            WebElement label = field.findElement(By.xpath("//input[@type='text']/ancestor::div[contains(@class,'label')]//label"));
            if (label.getText().trim().contains(fieldName)) {
                return field;
            }
        }

        return null;
    }

    public WebElement getFieldByPlaceHolder(String placeHolder) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fielLocators));
        List<WebElement> fields = driver.findElements(fielLocators);

        for (WebElement field : fields) {
            if (field.getAttribute("placeholder").trim().contains(placeHolder)) {
                return field;
            }
        }

        return null;
    }
}
