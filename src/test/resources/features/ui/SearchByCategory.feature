@SearchCategoryFeature @BlibliPage @UI @Regression
Feature: Search By Category

  @Positive
  Scenario: Search by kamera category success
    Given [ui] blibli page is opened
    When  [ui] search using kamera mirrorless category
    Then  [ui] category title equal with 'kamera, mirrorless'