@CreateNewRequest
Feature: Create new payment feature

  @Regression @PrincipalOnly
  Scenario Outline: Verify new payment request
    Given The principal dashboard screen
    When I click create new request button
    And I enter "<Beneficiary name>" and amount
    And I select financial assitance and enter fund request reason
    And I select category and enter addtional information
    And I select payment method and I accept terms and conditions
    Then The payment request should be created successfully

    Examples:
    |Beneficiary name|
    |Manoj           |
    |Kannan          |
    |Bala            |
   