@CuratedKeywordsFeature @Search @API @Regression
Feature: Curated keywords

  @Positive
  Scenario: Get curated keywords success
    When  [api] send get curated keywords request
    Then  [api] get status code must be '200'