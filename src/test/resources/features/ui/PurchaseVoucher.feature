@PurchaseVoucherFeature @BlibliPurchaseItem @UI @Regression
  Feature: Purchase Voucher

    @Positive
    Scenario: Purchase voucher success
      Given [ui] blibli page is opened
      When  [ui] see all category
      And   [ui] select voucher category 'Tagihan' then 'Voucher'
      And   [ui] buy 'Steam' game credit voucher
      And   [ui] select voucher nominal by index '2'
      And   [ui] continue to payment
      And   [ui] do login for voucher payment with credential 'emailforautomationtesting2@gmail.com' and 'blibli123blibli123'
      And   [ui] select lv one payment 'Transfer' for voucher
      And   [ui] select lv two payment 'BCA' for voucher
      And   [ui] click buy now button
      Then  [ui] assert that order voucher is success
