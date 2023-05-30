Feature: PB Login

  Scenario: Verify PB login functionality on chrome
    Given Chrome is opened and PB app is opened
    When User enters correct Username and Password
    And User clicks on login button
    Then It shows home page
