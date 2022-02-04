Feature: Practising cucumber
  @practise
  Scenario: When user does a search
    Given user opens Greenkart Homepage
    When user does a search and gets the product name
    #When user does many search
    #|Cucumber|
    #|Potato |
    #|Tomato|
    And user goes to Top Deals and does a search "Tomato"
    Then user is checks if Top deals is available for searched product