@PrincipalInvite
Feature: Principal invite feature
  @Regression @AdminOnly
  Scenario: Verify principal invite feature
    Given The admin dashboard with principal managment section
    When I click invite principal button
    And I enter principal name and email
    And I select principal list and click invite button
    Then The principal invite should be successful
