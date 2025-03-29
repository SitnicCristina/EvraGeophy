Feature: PreLogin functionality

  @PreLogin
  Scenario: Welcome to Evra Section: Click Sign in with Google - redirect to Sign In with Google page
    Given the user is on Evra Home Page
    And the section "Welcome to Evra" is displayed on the page
    When The user clicks on the "Sign in with Google" button
    Then The user should be redirected to the Sign In with Google page
