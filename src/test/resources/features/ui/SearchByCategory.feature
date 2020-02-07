@SearchCategoryFeature @GooglePage @UI @Regression
Feature: Search By Category

  @Positive
  Scenario: Search by gaming audio category success
    Given [ui] blibli page is opened
    When  [ui] search using gaming audio category
    Then  [ui] category title equal with 'headset, earphone, speaker'