package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page.PageObjects.PropertyDueDiligence;
import org.example.page.components.BaseComponent;
import org.example.page.elements.Field;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PostLoginStepdefs extends BaseComponent {

    Field field = new Field();
    PropertyDueDiligence propertyDueDiligence = new PropertyDueDiligence();

    @When("the user enters {string} in the field with {string} placeholder")
    public void  theUserEntersInTheSearchPropertySearchField(String searchPropertyValue, String placeHolder) {
        wait.until(ExpectedConditions.visibilityOf(field.getFieldByPlaceHolder(placeHolder))).sendKeys(searchPropertyValue);
        Assert.assertTrue(field.getFieldByPlaceHolder(placeHolder).isDisplayed());
    }

    @Then("the user should be able to see the {string} panel")
    public void theUserShouldBeAbleToSeeThePanel(String panelName) {
        Assert.assertTrue(propertyDueDiligence.getPanel().getText().toLowerCase().contains(panelName.toLowerCase()));
    }


}
