@Login
Feature: Small moves foundation web login  feature

@Regression @AdminOnly
 Scenario Outline: Verify the user login feature with invalid credential
    Given The invalid login input payload with "<email1>" "<password1>"
    When The user clicks signIn button
    Then The login should be failed and response should be "Username or password is incorrect."

      Examples: 
      | email1           | password1|
      | admin@gmail.com  | admin@12 |
      
 @Regression @AdminOnly @testc
  Scenario Outline: Verify the user login feature with valid credential
    Given The valid login input payload with "<email1>" "<password1>"
    When The user clicks login button
    Then The login should be successful
 
 Examples: 
      | email1               | password1|
      | treva.sporer@example.com | password |