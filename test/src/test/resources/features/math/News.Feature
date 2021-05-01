Feature: News Topics

  Scenario Outline: User should be able to select any topic (E.g “Business and Economy”) and filter news using Apply button
    Given the user is on NSW Government News Page
    When he click on Select Topics Button
    And Selects "<Topic>" and clicks Apply
    Then the News Item Cards will be filtered based on the "<Topic>" Selected
    Examples:
      |Topic|
      |Arts & Culture|
      |Awards        |

  Scenario Outline: When filter (one or more) is being applied to news items and user clicks on “Reset” button, all applied filters should be removed
    Given the user is on NSW Government News Page
    When he click on Select Topics Button
    And Selects "<Topic>" and clicks Apply
    Then the News Item Cards will be filtered based on the "<Topic>" Selected
    And when user click on the Reset button
    Then the filters are removed from the selected "<Topic>"
    Examples:
      |Topic|
      |Arts & Culture|


