Feature: PreLogin functionality

  @PreLogin
  Scenario: Welcome to Evra Section: Click Sign in with Google - redirect to Sign In with Google page
    Given The user is on the "Welcome to Evra" Section page
    When The user clicks on the "Sign in with Google" button
    Then The user should be redirected to the Sign In with Google page
