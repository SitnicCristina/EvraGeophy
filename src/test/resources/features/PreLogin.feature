Feature: PreLogin functionality

  @PreLogin
  Scenario: Welcome to Evra Section: Click Sign in with Google - redirect to Sign In with Google page
    Given The user is on Evra Home Page
    And The section "Welcome to Evra" is displayed on the page
    When The user clicks on the "Sign in with Google" button
    Then The user should be redirected to the Sign In with Google page

  Scenario: Signing in with Google - redirect to Evra Dashboard Page
    Given The user is on Evra Home Page
    And The section "Welcome to Evra" is displayed on the page
    When The user clicks on the "Sign in with Google" button
    Then The user should be redirected to the Sign In with Google page
    When the user sign in with valid Google account credentials
    Then The user should be redirected to the Evra Dashboard Page


