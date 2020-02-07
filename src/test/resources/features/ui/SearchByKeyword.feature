@SearchKeywordFeature @BlibliPage @UI @Regression
Feature: Search By Keyword

  @Positive
  Scenario: Search by keyword success
    Given [ui] blibli page is opened
    And   [ui] set keyword to 'iphone'
    When  [ui] search using keywords
    Then  [ui] search result should containing keyword