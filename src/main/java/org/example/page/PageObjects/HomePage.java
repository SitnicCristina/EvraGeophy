package org.example.page.PageObjects;

import org.example.page.components.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseComponent {

    private final static By homePageHeading = By.tagName("h1");
    private final static By signInWithGooglePageTitle = By.xpath("//div[text()='Sign in with Google']");

    public static WebElement getHomePageHeading() {
        return driver.findElement(homePageHeading);
    }

    public static WebElement getSignInWithGooglePageTitle() {
        return driver.findElement(signInWithGooglePageTitle);
    }



}
