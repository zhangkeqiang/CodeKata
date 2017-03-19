Feature: Belly

  Scenario: a few cukes
    Given I have 42 cukes in my belly
    When I wait 2 hour
    Then my belly should growl to 84
    
  Scenario: a few cukes2
    Given I have 12 cukes in my belly
    When I wait 2 hour
    Then my belly should growl to 24