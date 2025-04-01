package org.example.page.elements;

import org.example.page.components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Link extends BaseComponent {

    private static final By linkLocators = By.cssSelector("div[data-test='signup-link'], a");

    private WebElement link;

    public static WebElement getLinkByText(String linkText) {
        return driver.findElements(linkLocators).stream()
                .filter(element -> element.getText().equalsIgnoreCase(linkText))
                .findFirst()
                .orElse(null);
    }

    public void click() {
        wait.until(ExpectedConditions.elementToBeClickable(link)).click();
    }

}
