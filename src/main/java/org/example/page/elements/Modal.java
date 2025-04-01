package org.example.page.elements;

import org.example.page.components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Modal extends BaseComponent {

    private static final By shadowRootManager = By.id("transcend-consent-manager");
    private static final By modalLocators = By.cssSelector(".modal-container, .terms-modal");
    private static final By modalTitleLocators = By.cssSelector(".text-title, .font-medium");
    private static final By checkboxLocators = By.cssSelector("input[type='checkbox']");

    public static WebElement getShadowModalByTitle(String modalTitle) {
        try {
            // Step 1: Locate the shadow host element
            WebElement shadowHost = driver.findElement(shadowRootManager);

            // Step 2: Get the shadow root
            SearchContext shadowRoot = shadowHost.getShadowRoot();

            // Step 3: Get the modal
            WebElement shadowModal = shadowRoot.findElement(modalLocators);

            // Step 4: Get the title inside the modal
            WebElement title = shadowModal.findElement(modalTitleLocators);

            if (title.getText().contains(modalTitle)) {
                return shadowModal;
            } else {
                System.out.println("Modal title does not match: " + title.getText());
            }

        } catch (NoSuchElementException e) {
            System.out.println("Modal or title element not found in shadow DOM.");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        return null;
    }

    public static WebElement getModalByTitle(String modalTitle) {
        List<WebElement> modals = driver.findElements(modalLocators);

        for (WebElement modal : modals) {
            WebElement title = modal.findElement(modalTitleLocators);

            if (title.getText().contains(modalTitle)) {
                return modal;
            }
        }

        return null;
    }

    public static WebElement getModalCheckbox(String checkboxName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalLocators));

        List<WebElement> checkboxes = driver.findElements(checkboxLocators);

        for (WebElement checkbox : checkboxes) {
            WebElement label = checkbox.findElement(By.xpath("//input[@type='checkbox']/following-sibling::span"));
            if (label.getText().equalsIgnoreCase(checkboxName)) {
                return checkbox;
            }
        }

        return null;
    }

    //TO DO  add the modal button method here
}
