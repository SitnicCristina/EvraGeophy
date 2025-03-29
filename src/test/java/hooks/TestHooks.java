package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.page.components.BaseComponent;
import org.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public class TestHooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();

        // Make driver accessible to BaseComponent
        BaseComponent.setBaseComponent(driver);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
