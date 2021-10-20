@PrincipalProfile
Feature: View principal profile
  
   @Regression @PrincipalOnly
  Scenario: Verify view principal profile feature
    Given The principal profile screen
    When I get principal profile name from profile screen
    Then The principal profile name should match with the actual principal name

