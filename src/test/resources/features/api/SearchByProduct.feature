@SearchByProductFeature @Search @API @Regression
Feature: Search by product

  @Positive
  Scenario: Search by product success
    Given [api] set search term to 'adidas'
    When  [api] send get search by product request
    Then  [api] get status code must be '200'

  @Positive
  Scenario: Search by product success
    Given [api] set search term to 'nike'
    When  [api] send get search by product request2
    Then  [api] get status code must be '200'