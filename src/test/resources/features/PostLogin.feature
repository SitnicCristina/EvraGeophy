Feature: PostLogin functionality

  @PreLogin
  Scenario: Property Due Diligence - Search for a Property
    Given the user is on Evra Home Page
    And the section "Welcome to Evra" is displayed on the page
    When the user clicks on the "Log in with email" button
    And the user should be redirected to the "Sign In" page
    And the user sign in with valid Evra credentials
    Then the user should be redirected to the Evra Dashboard Page
    #    Search a property on Property Due Diligence
    When the user clicks on the "View Sample Property" link
    Then the user should be able to see the "Evra Analysis" panel


  @PreLogin
  Scenario: Property Due Diligence - Property map - filtering
    Given the user is on Evra Home Page
    And the section "Welcome to Evra" is displayed on the page
    When the user clicks on the "Log in with email" button
    And the user should be redirected to the "Sign In" page
    And the user sign in with valid Evra credentials
    Then the user should be redirected to the Evra Dashboard Page
    #    Search a property on Property Map
    Given the user is on "Property Map" Page
    When the user inserts Min Value "5" and Max Value "6" in "Units" section on Filters panel
    And the user select Value "A" on the Neigborhood Rating grid
    And the user checks the "Urban Core" checkbox on the section "Neighborhood Type"
    Then the entities are listed on the table "Properties"


