Feature: TipCalculator Functionality
  As a customer of Lodge
  I want to be able calculate the tip
  So that i can give exact tip to staff of lodge

  Scenario: Test with Empty inputs
    Given I am on tip calculater page
    When I clear tip percentage input filed make sure its zero
    And I click on caluculate button
    Then An error message 'Please Enter a Valid Input.' can be visible

  Scenario: Test with Invalid inputs
    Given I am on tip calculater page
    When I entered invalid input
    And I click on caluculate button
    Then An error message 'Please Enter a Valid Input.' can be visible

  Scenario: Test with Valid inputs
    Given I am on tip calculater page
    When I entered bill amount
    And I ented tip percentage
    And I click on caluculate button
    Then I can see bill amount and tip amount