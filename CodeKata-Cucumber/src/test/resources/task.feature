Feature: Task

  Scenario Outline: get job done
    Given my task list has <total> tasks 
    When I finished <finished> tasks
    When I finished <again> tasks
    Then I have <left> tasks left

Examples:
|total|finished|again|left| 
| 22  | 12     |2| 8 |
| 18  | 12     |1| 5  |