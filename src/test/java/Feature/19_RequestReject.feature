@RequestReject
Feature: Request reject feature

@Regression @AdminOnly 
  Scenario: Verify request reject feature
    Given The admin request screen
    When The admin user clicks reject button
    Then The request should be rejected successfully
 
