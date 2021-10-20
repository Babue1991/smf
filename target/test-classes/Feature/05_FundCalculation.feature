@FundCalculation
Feature: Total allocated fund validation
  @Regression @PrincipalOnly
  Scenario: Verify total allocated fund display
    Given I principal users dashboard
    When I add allocated fund and remaining fund
    Then The fund should match with total allocated fund
