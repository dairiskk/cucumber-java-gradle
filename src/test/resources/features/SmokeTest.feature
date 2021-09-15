@test
Feature: This is feature

  Scenario: Test scenario
    Given I navigate to "https://www.cp.pt/"
    Then I switch language to "english"
    Then I click on "Buy Tickets" navigation menu
    Then I search the train from "Lagos" to "Porto - Campanha"
    Then I select towards date that is 3 "days" from today
    Then I select backwards date that is 6 "days" from today
    Then I click "first class seats" button
    Then I select "3 Passengers" from the dropdown
    Then I click "submit" button
    Then I validate outward table in service step equals "OUTWARD Lagos > Porto - Campanha"
    Then I validate inward table in service step equals "INWARD Porto - Campanha > Lagos"
    Then I select option number "1" in "outward" table
    Then I select option number "1" in "inward" table
    Then I press "agree with terms checkbox" in service page
    Then I press "continue button" in service page
    Then I validate element visibility in Ticket Office Options section
      | email    | is |
      | password | is |
    Then I click on "cancel button" in Options page
    Then I validate that currently "buy tickets" page is opened
    Then I validate that buy tickets page contains correct values
      | from place      | _fromPlace  |
      | to place        | _toPlace    |
      | from date       | _fromDate   |
      | to date         | _toDate     |
      | seat class      | _seatClass  |
      | passenger count | _passengers |



