Feature: add a new computer SCAFRA

  Scenario: add new computer
    Given I have entered computer details using pre requisite scenario one point one
    When I click create this computer
    Then the computer details I have entered are displayed in the main listing correctly
