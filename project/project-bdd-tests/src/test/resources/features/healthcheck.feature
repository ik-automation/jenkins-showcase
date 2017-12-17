Feature: Application Server is healthy

  Scenario: Inform client that service is up
    When the client performs GET request on "/gadgetservice/v1/health"
    Then status code is 200
    And response contains property "status" with value "UP"

