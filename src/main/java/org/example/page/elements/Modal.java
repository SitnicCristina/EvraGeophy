package org.example.page.elements;

import org.example.page.components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Modal extends BaseComponent {

    private static final By shadowRootManager = By.id("transcend-consent-manager");
    private static final By modalLocators = By.className("modal-container");
    private static final By modalTitleLocators = By.id("consent-dialog-title");

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

}
