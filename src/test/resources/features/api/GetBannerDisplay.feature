@BannerDisplayFeature @Search @API @Regression
Feature: Banner display

  @Positive
  Scenario: Get banner display success
    Given [api] set page name to 'HOMEPAGE'
    And   [api] set display type to 'mobile'
    When  [api] send get banner display request
    Then  [api] get status code must be '200'