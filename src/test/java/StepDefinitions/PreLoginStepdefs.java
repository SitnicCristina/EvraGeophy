package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page.PageObjects.HomePage;
import org.example.page.components.BaseComponent;
import org.example.page.components.Section;
import org.example.page.elements.Button;
import org.example.utils.DriverFactory;
import org.example.utils.ReadConfigFile;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PreLoginStepdefs extends BaseComponent {

    WebDriver driver = DriverFactory.getDriver();
    ReadConfigFile config = new ReadConfigFile();
    HomePage homePage = new HomePage();

    @Given("The user is on Evra Home Page")
    public void theUserIsOnEvraHomePage() throws InterruptedException {
        String baseUrl = config.getBaseUrl();
        driver.get(baseUrl);

        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageHeading()));
        homePage.acceptAllCookiesIfDisplayed();
    }

    @And("The section {string} is displayed on the page")
    public void theSectionIsDisplayedOnThePage(String sectionPage) {
        Assert.assertTrue(Section.isSectionPageDisplayed(sectionPage));
    }

    @When("The user clicks on the {string} button")
    public void iClickOnTheButton(String buttonName) {
        WebElement btn = Button.getButtonByText(buttonName);
        wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
    }

    @Then("The user should be redirected to the Sign In with Google page")
    public void iShouldBeRedirectedToTheSignInWithGooglePage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));//update with check the new url changed or something else
        wait.until(ExpectedConditions.visibilityOf(homePage.getSignInWithGooglePageTitle()));
    }

    @When("the user sign in with valid Google account credentials")
    public void theUserSignInWithValidGoogleAccountCredentials() {
        homePage.enterValidGoogleCredentials();
    }

    @Then("The user should be redirected to the Evra Dashboard Page")
    public void theUserShouldBeRedirectedToTheEvraDashboardPage() {
        wait.until(ExpectedConditions.visibilityOf(homePage.getHomeNavigationMenu()));
    }

}
