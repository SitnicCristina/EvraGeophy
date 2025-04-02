package org.example.page.PageObjects;

import org.example.page.components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PropertyDueDiligence extends BaseComponent {

    private final static By panel = By.cssSelector("div[data-test='panel-2']");

    public WebElement getPanel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(panel));
    }
}
