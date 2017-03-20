Feature: CakeTable

  Scenario: a few cukes
    Given I prepare some 3 cukes
    When I generate a report
    |key1|value1|
    |key2|value2|
    |girl1|wangliting|
    |girl2|mengwanyi|
    
    Then I should see the following cukes:
    | Latin           | English      |
    | Cucumis sativus | Cucumber     |
    | Cucumis anguria | Burr Gherkin |
    