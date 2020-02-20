@PurchaseItemsFeature @BlibliPurchaseItem @UI @Regression
Feature: Purchase Items

  @Positive
  Scenario: Purchase items success
    Given [ui] blibli page is opened
    When  [ui] select category 'Komputer' and 'USB'
    And   [ui] select filter official store
    And   [ui] select product number '3'
    And   [ui] select quantity '2'
    And   [ui] do login with email 'emailforautomationtesting@gmail.com' and 'blibli123'
    And   [ui] go to cart and checkout
    And   [ui] select lv one payment 'Transfer'
    And   [ui] select lv two payment 'BCA'
    And   [ui] pay using bayar sekarang button
    Then  [ui] assert that order is success

