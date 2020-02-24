package com.khalidabdul.steps.ui;

import com.khalidabdul.module.ui.BlibliPurchaseVoucher;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import static org.junit.Assert.assertThat;

public class BlibliPurchaseVoucherSteps extends ScenarioSteps {

    BlibliPurchaseVoucher blibliPurchaseVoucher;

    @When("^\\[ui] see all category$")
    public void see_all_category () {
        blibliPurchaseVoucher.seeAllCategory();
    }

    @When("^\\[ui] select voucher category '(.*)' then '(.*)'$")
    public void select_voucher_category (String value1, String value2) {
        blibliPurchaseVoucher.selectCategoryLvOne(value1);
        blibliPurchaseVoucher.selectCategoryLvTwo(value2);
    }

    @When("^\\[ui] buy '(.*)' game credit voucher$")
    public void buy_game_credit_voucher (String value) {
        blibliPurchaseVoucher.selectGameCreditVoucher(value);
    }

    @When("^\\[ui] select voucher nominal by index '(\\d+)'$")
    public void select_voucher_nominal_by_index (int index) {
        blibliPurchaseVoucher.selectNominal(index);
    }

    @When("^\\[ui] continue to payment$")
    public void continue_to_payment() {
        blibliPurchaseVoucher.doContinueToPayment();
    }

    @When("^\\[ui] select lv one payment '(.*)' for voucher$")
    public void select_lv_one_payment(String payment) {
        blibliPurchaseVoucher.selectPaymentLevelOne(payment);
    }

    @When("^\\[ui] select lv two payment '(.*)' for voucher$")
    public void select_lv_two_payment(String payment) {
        blibliPurchaseVoucher.selectPaymentLevelTwo(payment);
    }

    @When("^\\[ui] do login for voucher payment with credential '(.*)' and '(.*)'$")
    public void do_login_for_voucher_payment (String email, String password) {
        blibliPurchaseVoucher.doLogin(email, password);
    }

    @When("^\\[ui] click buy now button$")
    public void click_payment_buy_now_button() {
        blibliPurchaseVoucher.doPaymentBuyNow();
    }

    @Then("^\\[ui] assert that order voucher is success$")
    public void assert_that_order_voucher_is_success() {
        assertThat(blibliPurchaseVoucher.isPaymentSuccess().toLowerCase(), Matchers.containsString("menunggu pembayaran"));
        blibliPurchaseVoucher.orderSuccess();
    }

}
