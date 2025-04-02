package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page.PageObjects.HomePage;
import org.example.page.components.BaseComponent;
import org.example.page.elements.*;
import org.example.utils.DriverFactory;
import org.example.utils.ReadConfigFile;
import org.example.utils.StringUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PreLoginStepdefs extends BaseComponent {

    WebDriver driver = DriverFactory.getDriver();
    ReadConfigFile config = new ReadConfigFile();
    HomePage homePage = new HomePage();
    Modal modal = new Modal();
    Link link = new Link();
    Field field = new Field();

    private StringUtil stringUtil = new StringUtil();

    @Given("the user is on Evra Home Page")
    public void theUserIsOnEvraHomePage() throws InterruptedException {
        String baseUrl = config.getBaseUrl();
        driver.get(baseUrl);

        wait.until(ExpectedConditions.visibilityOf(homePage.getHomePageHeading()));
        homePage.acceptAllCookiesIfDisplayed();
    }

    @And("the section {string} is displayed on the page")
    public void theSectionIsDisplayedOnThePage(String sectionPage) {
        Assert.assertTrue(Section.isSectionPageDisplayed(sectionPage));
    }

    @When("the user clicks on the {string} button")
    public void iClickOnTheButton(String buttonName) {
        WebElement btn = Button.getButtonByText(buttonName);
        wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
    }

    @When("the user clicks on the {string} link")
    public void theUserClicksOnTheButtonLink(String buttonLinkName) {
        wait.until(ExpectedConditions.elementToBeClickable(link.getLinkByText(buttonLinkName))).click();
    }

    @Then("the user should be redirected to the Sign In with Google page")
    public void iShouldBeRedirectedToTheSignInWithGooglePage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        wait.until(ExpectedConditions.visibilityOf(homePage.getSignInWithGooglePageTitle()));
    }

    @When("the user sign in with valid Google account credentials")
    public void theUserSignInWithValidGoogleAccountCredentials() {
        homePage.enterValidGoogleCredentials();
    }

    @Then("the user should be redirected to the Evra Dashboard Page")
    public void theUserShouldBeRedirectedToTheEvraDashboardPage() {
        Assert.assertTrue(homePage.getHomeNavigationMenu().isDisplayed());
    }

    @Then("the modal with text {string} is visible")
    public void theModalWithTextIsVisible(String modalName) {
      Assert.assertTrue(modal.getModalByTitle(modalName).isDisplayed());
    }

    @And("the user checks the {string} checkbox on the modal")
    public void theUserChecksTheCheckboxOnTheModal(String checkboxName) {
        modal.getModalCheckbox(checkboxName).click();
    }

    @And("the user enters a random string in the {string} field")
    public void theUserEntersARandomStringInTheField(String fieldName) {
        WebElement textField = field.getFieldByLabel(fieldName);
        textField.sendKeys(stringUtil.randomAlphanumeric(8));
    }

    @And("the user enters {string} in the {string} field")
    public void theUserEntersInTheField(String inputValue, String fieldName) {
        WebElement textField = field.getFieldByLabel(fieldName);
        textField.sendKeys(inputValue);
    }

    @And("the user should be redirected to the {string} page")
    public void theUserShouldBeRedirectedToThePage(String pageName) {
        Assert.assertTrue(homePage.getSignPageTitle().getText().equalsIgnoreCase(pageName));
    }

    @And("the user sign in with valid Evra credentials")
    public void theUserSignInWithValidEvraCredentials() {
        homePage.enterValidEvraCredentials();
    }
}
