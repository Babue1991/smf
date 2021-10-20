@PrincipalLogout
Feature: Principal logout feature
  @Regression @PrincipalOnly
  Scenario: Verify principal logout feature
    Given The principal users screen
    When I click logout button from principal login
    Then The pricipal should be logged out successfully