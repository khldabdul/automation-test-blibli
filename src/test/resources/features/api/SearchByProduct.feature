@SearchByProductFeature @Search @API @Regression
Feature: Search by product

  @Positive
  Scenario: Search by product success
    Given [api] set search term to 'adidas'
    When  [api] send get search by product no '3' request
    Then  [api] get status code must be '200'