Feature: Application Login

  Scenario: Home page default login
    Given user is on NetBanking landing page
    When user logs in into application with "jin" and password "1234"
    Then Home page is populated
    And Cards are displayed "true"

  Scenario: Home page default login
    Given user is on NetBanking landing page
    When user logs in into application with "john" and password "4321"
    Then Home page is populated
    And Cards are displayed "false"
