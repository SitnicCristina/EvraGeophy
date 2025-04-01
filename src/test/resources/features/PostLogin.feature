Feature: PostLogin functionality

  @PreLogin
  Scenario: Signing in with Google account - redirect to Evra Dashboard Page
    Given the user is on Evra Home Page
    And the section "Welcome to Evra" is displayed on the page
    When the user clicks on the "Sign in with Google" button
    Then the user should be redirected to the Sign In with Google page
    When the user sign in with valid Google account credentials
    Then the user should be redirected to the Evra Dashboard Page
    #    Search a property
    When the user enters "501 W Adams St Jacksonville, FL 32202, USA" in the field with placeholder "Search for a property by name or address"
    And the user selects first suggestion from the search results
    Then the user should be redirected to the Evra Analysis page
