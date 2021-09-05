@test
Feature: This is feature
  Scenario: Test scenario
    Given I navigate to "https://www.cp.pt/"
    Then I switch language to "EN"
    Then I search the train from "Lagos" to "Porto - Companha"
    Then I select towards date that is 3 "days" from today
    Then I select backwards date that is 6 "days" from today
    Then I select "1st" class / comfort for "3" passengers
    Then I save these options
