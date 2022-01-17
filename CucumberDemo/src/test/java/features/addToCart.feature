@featureFileAddToCart
Feature: Testing add to cart functionality
  Scenario: the user should be able to search the product
    Given user is in home page
    When user logs in
    | shivani@gmail.com | shivani@123 |
    And user types in search bar and clicks enter "tshirt"
    Then user should be taken to search result page

  @mandatoryTest
  Scenario Outline: when user searches
      Given user is in home page
      When user searches "<TypeText>"
      Then user should be taken to search result page

      Examples:
      | TypeText |
      | vneck  |
      | polo     |
      | hoodies |

      Scenario: the user gives wrong credentials
        Given user is in home page
        When user enters wrong credentials
        | shivani123@gmail.com | shivani@123 |
        Then user shouldn't be logged in