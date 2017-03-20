Feature: CukeTable

  Scenario: check a few cukes
    Given I prepare 3 cukes
    And I like cake
    |cake1|anny|
    |cake2|lily|
    When I generate a report
    |key1|value1|
    |key2|value2|
    |girl1|wangliting|
    |girl2|mengwanyi|
    
    Then I should see the following cukes:
    | Latin           | English      |
    | Cucumis sativus | Cucumber     |
    | Cucumis anguria | Burr Gherkin |
    
    But I should not see 5.14 cakes