package org.example.page.PageObjects;

import org.example.page.components.BaseComponent;
import org.example.page.elements.Button;
import org.example.page.elements.Modal;
import org.example.utils.ReadConfigFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BaseComponent {

    private final static By homePageHeading = By.tagName("h1");
    private final static By homeNavigationMenu = By.tagName("h1");
    private final static By signInWithGooglePageTitle = By.xpath("//div[text()='Sign in with Google']");
    private final static By googleEmailField = By.cssSelector("input[type='email']");
    private final static By googleEmailPassField = By.cssSelector("input[type='email']");

    static ReadConfigFile config = new ReadConfigFile();

    private Modal modal;
    private Button button;

    public static WebElement getHomePageHeading() {
        return driver.findElement(homePageHeading);
    }

    public static WebElement getHomeNavigationMenu() {
        return driver.findElement(homeNavigationMenu);
    }

    public WebElement getSignInWithGooglePageTitle() {
        return driver.findElement(signInWithGooglePageTitle);
    }

    public void enterValidGoogleCredentials() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(googleEmailField))
                .sendKeys(config.getGoogleEmail());
        button.getButtonByText("Next").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(googleEmailPassField))
                .sendKeys(config.getGoogleEmailPass());
        button.getButtonByText("Next").click();
    }

    public void acceptAllCookiesIfDisplayed() {
        WebElement cookieModal = modal.getShadowModalByTitle("WE USE COOKIES");

        if (cookieModal != null && cookieModal.isDisplayed()) {
            List<WebElement> buttons = cookieModal.findElements(By.className("button"));

            for (WebElement button : buttons) {
                if (button.getText().trim().equalsIgnoreCase("Accept All")) {
                    button.click();
                    return;
                }
            }
        }
    }
}
