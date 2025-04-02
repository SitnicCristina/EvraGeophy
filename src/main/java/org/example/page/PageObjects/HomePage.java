package org.example.page.PageObjects;

import org.example.page.components.BaseComponent;
import org.example.page.elements.Button;
import org.example.page.elements.Modal;
import org.example.utils.ReadConfigFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.example.utils.DriverFactory.waitForPageToLoad;

public class HomePage extends BaseComponent {

    private final static By homePageHeading = By.tagName("h1");
    private final static By homeNavigationMenu = By.className("nav-menu");
    private final static By signInWithGooglePageTitle = By.xpath("//div[text()='Sign in with Google']");
    private final static By signPageTitle = By.tagName("h2");
    private final static By googleEmailField = By.cssSelector("input[type='email'], input[type='text']");
    private final static By googleEmailPassField = By.cssSelector("input[type='password']");
    private final static By nextButtonSingInPage = By.cssSelector("input[value='Next']");
    private final static By verifyButtonSingInPage = By.cssSelector("input[value='Verify']");


    static ReadConfigFile config = new ReadConfigFile();

    private Modal modal;
    private Button button;

    public static WebElement getHomePageHeading() {
        return driver.findElement(homePageHeading);
    }

    public static WebElement getHomeNavigationMenu() {
        return new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(ExpectedConditions.visibilityOfElementLocated(homeNavigationMenu));
    }

    public WebElement getSignInWithGooglePageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInWithGooglePageTitle));
        return driver.findElement(signInWithGooglePageTitle);
    }

    public WebElement getSignPageTitle() {
        return new WebDriverWait(driver, Duration.ofSeconds(25))
                .until(ExpectedConditions.visibilityOfElementLocated(signPageTitle));
    }

    public void enterValidGoogleCredentials() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(googleEmailField))
                .sendKeys(config.getGoogleEmail());
        button.getButtonByText("Next").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(googleEmailPassField))
                .sendKeys(config.getGoogleEmailPass());
        button.getButtonByText("Next").click();
        waitForPageToLoad(driver,10);
    }

    public void enterValidEvraCredentials() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(googleEmailField))
                .sendKeys(config.getGoogleEmail());
        driver.findElement(nextButtonSingInPage).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(googleEmailPassField))
                .sendKeys(config.getGoogleEmailPass());
        driver.findElement(verifyButtonSingInPage).click();
        waitForPageToLoad(driver,10);
    }

    public void acceptAllCookiesIfDisplayed() {
        wait.withTimeout(Duration.ofSeconds(10));

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
