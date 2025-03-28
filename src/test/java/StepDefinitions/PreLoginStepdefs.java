package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PreLoginStepdefs {
    @Given("The user is on the {string} Section page")
    public void iAmOnTheSectionPage(String sectionPage) {
    }

    @When("The user clicks on the {string} button")
    public void iClickOnTheButton(String buttonName) {
    }

    @Then("The user should be redirected to the Sign In with Google page")
    public void iShouldBeRedirectedToTheSignInWithGooglePage() {
    }
}
