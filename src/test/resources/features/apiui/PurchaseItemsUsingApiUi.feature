@PurchaseItemsUsingApiUiFeature @BlibliPurchaseItem @APIUI @Regression
  Feature: Purchase Items using API & UI

    @Positive
    Scenario: Purchase item using API & UI success
      Given [api] set search term to 'airforce'
      When  [api] send get search by product no '1' request
      And   [ui] product page is opened
      And   [ui] select size of '42.5'
      And   [ui] select quantity '2'
      And   [ui] do login with email 'emailforautomationtesting@gmail.com' and 'blibli123'
      And   [ui] go to cart and checkout
      And   [ui] select lv one payment 'Transfer'
      And   [ui] select lv two payment 'BCA'
      And   [ui] pay using bayar sekarang button
      Then  [ui] assert that order is success