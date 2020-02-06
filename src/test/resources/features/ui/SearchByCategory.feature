@SearchCategoryFeature @GooglePage @UI @Regression
Feature: Search By Category

  @Positive
  Scenario: Search by category success
    Given [ui] blibli page is opened
    When  [ui] search using category
#    Then  [ui] search results should be containing keyword