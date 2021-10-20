@RequestCancel
Feature: Request approve feature

@Regression @PrincipalOnly
  Scenario: Verify payment request cancel feature
    Given The principal users dashboard screen
    When The principal user clicks cancel button
    Then The payment request should be cancelled successfully
 
