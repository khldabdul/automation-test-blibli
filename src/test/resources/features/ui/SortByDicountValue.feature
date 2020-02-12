@SortByDiscountValueFeature @BlibliPage @UI @Regression
  Feature: Sort By Discount Value

    @Positive
    Scenario: Descending sort by discount value
      Given [ui] blibli page is opened
      When  [ui] search using kamera mirrorless category
      And   [ui] sort by 'Potongan diskon'
      Then  [ui] sorted discount value should equals with request