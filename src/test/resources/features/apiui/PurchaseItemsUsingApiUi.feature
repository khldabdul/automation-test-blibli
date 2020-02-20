@PurchaseItemsUsingApiUiFeature @BlibliPurchaseItem @APIUI @Regression
  Feature: Purchase Items using API & UI

    @Positive
    Scenario: Purchase item using API & UI success
      Given [api] set search term to 'adidas'
      And   [ui] blibli page is opened