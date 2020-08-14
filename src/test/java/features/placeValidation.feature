Feature: Validating Place APIs


  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add place Payload with "<name>" "<language>" "<address>"
    When user calls "ADD_PLACE_API" with "post" http request
    Then user receives status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify placeId created maps to "<name>" using "GET_PLACE_API"

    Examples:
      | name   | language | address            |
      | Ahouse | English  | World cross center |
#      | Bhouse | Spanish  | Sea cross center   |

  @DeletePlace
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace PayLoad
    When user calls "DELETE_PLACE_API" with "POST" http request
    Then user receives status code 200
    And "status" in response body is "OK"
