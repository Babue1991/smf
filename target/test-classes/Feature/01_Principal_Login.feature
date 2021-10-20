@PrincipalLogin
Feature: Principal login feature

@Regression @principalOnly
  Scenario Outline: Verify the principal user login feature with valid credential
    Given The principal users username "<email1>" and password "<password1>"
    When The principal user clicks login button
    Then The principal users login should be successful
 
 Examples: 
      | email1             | password1 |
      | babufsp1@gmail.com | password  |