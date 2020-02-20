@GetPaymentActiveFeature @BlibliPurchaseItem @API @Regression
Feature: Get Payment Active

  @Positive
  Scenario: Get payment active success
    When  [api] send get payments active request
    Then  [api] get status code must be '200'