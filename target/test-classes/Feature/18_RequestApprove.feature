@RequestApprove
Feature: Request approve feature

@Regression @AdminOnly 
  Scenario: Verify request approve feature
    Given The admin user request screen
    When The admin user clicks approve button
    Then The request should be approved successfully
 
 