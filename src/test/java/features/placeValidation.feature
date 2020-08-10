Feature: Validating Place APIs
@Run
  Scenario: Verify if place is being successfully added using AddPlaceAPI
    Given Add place Payload
    When user calls "AddPlaceAPI" with post http request
    Then user receives status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
