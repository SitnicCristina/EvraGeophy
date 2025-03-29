package org.example.page.elements;

import org.example.page.components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Button extends BaseComponent {

    private static By buttonLocators = By.cssSelector("button[type='button'], div[role='button']");
    private WebElement button;

    public static WebElement getButtonByText(String buttonText) {
        return driver.findElements(buttonLocators).stream()
                .filter(element -> element.getText().contains(buttonText))
                .findFirst()
                .orElse(null);
    }

    public void click() {
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
}
