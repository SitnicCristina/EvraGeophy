package org.example.page.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.restassured.response.Response;

import java.time.Duration;

public class BaseComponent {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public static Response response;
    public static String bearerToken;

    public static void setBaseComponent(WebDriver driver) {
        BaseComponent.driver = driver;
        BaseComponent.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}
