@test
Feature: This is feature
  Scenario: Test scenario
    Given I navigate to "https://www.cp.pt/"
    Then I switch language to "EN"
    Then I search the train from "Lagos" to "Porto - Companha"
    Then I select towards date