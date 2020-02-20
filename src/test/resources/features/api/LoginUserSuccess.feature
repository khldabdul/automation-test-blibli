@LoginUserFeature @Users @API @Regression
Feature: Login User

  @Positive
  Scenario: Login user success
    Given [api] set username to 'emailforautomationtesting@gmail.com'
    And   [api] set password to 'blibli123'
    When  [api] send post login user request
    Then  [api] login user status code must be '200'
    And   [api] post login user response equals with request