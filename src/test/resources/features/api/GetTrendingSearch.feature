@TrendingSearchFeature @Search @API @Regression
Feature: Trending Search

  @Positive
  Scenario: Get trending search success
    When  [api] send get trending search request
    Then  [api] get status code must be '200'