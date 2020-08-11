Feature: Validating Place APIs

  @Run
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with post http request
    Then user receives status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
      | name   | language | address            |
      | Ahouse | English  | World cross center |
