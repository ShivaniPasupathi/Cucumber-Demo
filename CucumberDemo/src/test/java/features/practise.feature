Feature: Practising cucumber
  @practise
  Scenario: When user does a search
    Given user opens homepage
    When user does many search
    |shirt|
    |polo |
    |vneck|
    Then user is taken to search result page