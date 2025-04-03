package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page.apiEngine.EndPoints;
import org.example.page.components.BaseComponent;
import org.junit.Assert;

public class APIStepdefs extends BaseComponent {

    @Given("the user is authorized on Evra app")
    public void theUserIsAuthorizedOnEvraApp() {
        // Assuming you have a method to get the bearer token
        bearerToken = EndPoints.getBearerToken();
        System.out.println("Bearer Token: " + bearerToken);
    }


    @When("the user want to update the property with ID {string} to {string}")
    public void theUserWantToUpdateThePropertyWithIDTo(String propertyId, String propertyValue) {
        response = EndPoints.updateProperty(propertyId, propertyValue);
    }

    @Then("the user should receive a {string} response")
    public void theUserShouldReceiveAResponse(String responseCode) {
        // Get the response from the API
        String responseString = response.asString();
        System.out.println("Response: " + responseString);

        // Validate the Response
        int responseStatusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + responseStatusCode);
        Assert.assertEquals(responseStatusCode, responseCode);
    }
}
