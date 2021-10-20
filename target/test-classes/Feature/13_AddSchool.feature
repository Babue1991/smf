@AddSchool
Feature: Add new school
  @Regression @AdminOnly
  Scenario: Verify add new school feature
    Given The admin dashboard screen
    When I click add new school button
    And I enter school name
    And I enter enter street address, city and State
    And I enter zip code and phone number and clicks submit button
    Then The school should be created successfully
