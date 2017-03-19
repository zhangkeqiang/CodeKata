Feature: CakeTable

  Scenario: a few cukes
    Given I prepare some 3 cukes
    When I generate a report
    Then I should see the following cukes:
    | Latin           | English      |
    | Cucumis sativus | Cucumber     |
    | Cucumis anguria | Burr Gherkin |
    