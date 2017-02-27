Feature: delete computer SCAFRA

  Scenario: delete computer SCAFRA
    Given I have created a new computer using pre requisite scenario one
    And I have recalled the created computer
    When I delete the created computer
    
    Then The computer is deleted