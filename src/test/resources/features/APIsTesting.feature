Feature: Request Testing

  Scenario: Update Property Favorite Flag
    Given the user is authorized on Evra app
    When the user want to update the property with ID "91d9aa45-8ea5-4550-a5aa-aacbc0609988" to "true"
    Then the user should receive a "200 OK" response
