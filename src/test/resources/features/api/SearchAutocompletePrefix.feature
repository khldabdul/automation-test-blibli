@SearchAutocompletePrefixFeature @Search @API @Regression
Feature: Banner display

  @Positive
  Scenario: Search autocomplete prefix success
    Given [api] set search term prefix to 'sa'
    When  [api] send get search autocomplete prefix request
    Then  [api] get status code must be '200'