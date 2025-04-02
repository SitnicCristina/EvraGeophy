Feature: PreLogin functionality

  @PreLogin
  Scenario: Welcome to Evra Section: Click Sign in with Google - redirect to Sign In with Google page
    Given the user is on Evra Home Page
    And the section "Welcome to Evra" is displayed on the page
    When the user clicks on the "Sign in with Google" button
    Then the user should be redirected to the Sign In with Google page

  @PreLogin
  Scenario: Signing in with Google account - redirect to Evra Dashboard Page
    Given the user is on Evra Home Page
    And the section "Welcome to Evra" is displayed on the page
    When the user clicks on the "Sign in with Google" button
    Then the user should be redirected to the Sign In with Google page
    When the user sign in with valid Google account credentials
    Then the user should be redirected to the Evra Dashboard Page

  @PreLogin
  Scenario: Signing up with email - Register a new user
    Given the user is on Evra Home Page
    And the section "Welcome to Evra" is displayed on the page
    When the user clicks on the "Sign up with email" link
    Then the modal with text "Terms & Conditions" is visible
    And the user checks the "I agree to the terms and conditions and privacy policy." checkbox on the modal
    When the user clicks on the "Accept" button
    Then the user should be redirected to the "Sign Up" page
    And the user enters a random string in the "First name" field
    And the user enters a random string in the "Last name" field
    And the user enters "test.evra.geothy@gmail.com" in the "Email" field
    #TO DO Set up security methods
