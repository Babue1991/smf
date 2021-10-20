@PrincipalDelete
Feature: Principal delete feature
  @Regression @AdminOnly
  Scenario: Verify principal delete feature from admin login
    Given The principal management screen
    When I click delete button from principal management
    Then The pricipal should be deleted successfully.
