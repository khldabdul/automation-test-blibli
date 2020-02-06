@LoginUserFeature @Users @API @Regression
Feature: Login User

  @Negative
  Scenario Outline: Login user failed because '<reason>'
    Given [api] set username to '<username>'
    And   [api] set password to '<password>'
    When  [api] send post login user request
    Then  [api] login user status code must be '<status code>'

    Examples:
      | username          | password  | reason                    | status code |
      | null              | null      | both null                 | 400         |
      | null              | password  | email is null             | 400         |
      | khalidemail.com   | 123456    | email is not valid        | 400         |
      | khalid@email.com  | 123456    | email/password is wrong   | 401         |