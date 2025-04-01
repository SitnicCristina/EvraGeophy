package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page.components.BaseComponent;
import org.example.page.elements.Button;
import org.example.page.elements.Field;
import org.openqa.selenium.WebElement;

public class PostLoginStepdefs extends BaseComponent {

    Field field = new Field();

    @When("the user enters {string} in the field with placeholder {string}")
    public void theUserEntersInTheSearchPropertySearchField(String searchPropertyValue, String placeHolder) {
        field.getFieldByPlaceHolder(placeHolder).sendKeys(searchPropertyValue);
    }

    @And("the user selects first suggestion from the search results")
    public void theUserSelectsFirstSuggestionFromTheSearchResults() {
    }

    @Then("the user should be redirected to the Evra Analysis page")
    public void theUserShouldBeRedirectedToTheEvraAnalysisPage() {

    }
}
