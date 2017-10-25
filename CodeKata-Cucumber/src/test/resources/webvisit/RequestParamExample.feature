Feature: Request Param Example
  Scenario: visit localhost input
    Given I visit "http://localhost:8080/examples/servlets/servlet/RequestParamExample"
    When I input first name:"ZHANG" and last name:"Mike"
    Then I see First Name:"ZHANG"