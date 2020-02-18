package com.khalidabdul.steps.ui;

import com.khalidabdul.module.ui.BlibliPurchaseItem;
import com.khalidabdul.module.ui.data.BlibliPageData;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import static org.junit.Assert.assertThat;

public class BlibliPurchaseItemSteps extends ScenarioSteps {

    BlibliPurchaseItem blibliPurchaseItem;

    //-------------- PREPARATION
    @Given("^\\[ui] blibli page for purchase is opened$")
    public void blibli_page_is_opened() {
        blibliPurchaseItem.openHomePage();
    }

    //-------------- ACTIONS
    @When("^\\[ui] select category '(.*)' and '(.*)'$")
    public void select_category(String value1, String value2){
        blibliPurchaseItem.selectCategory(value1, value2);
    }

    @When("^\\[ui] select filter official store$")
    public void select_filter_official_store() {
        blibliPurchaseItem.officialStoreCheckbox();
    }

    @When("^\\[ui] select product number '(.*)'$")
    public void select_product(String value){
        blibliPurchaseItem.selectProductCard(value);
        blibliPurchaseItem.getProductTitle();
    }

    @When("^\\[ui] select quantity '(\\d+)'$")
    public void select_quantity(int qty) {
        blibliPurchaseItem.setQuantityInput(qty);
    }

    @When("^\\[ui] do login with email '(.*)' and '(.*)'$")
    public void do_login_with(String email, String password) {
        BlibliPageData.setEmail(email);
        BlibliPageData.setPassword(password);
        blibliPurchaseItem.doLogin();
    }

    @When("^\\[ui] go to cart and checkout$")
    public void go_to_cart_and_checkout() {
        blibliPurchaseItem.goToCart();
        blibliPurchaseItem.checkout();
    }

    @When("^\\[ui] select lv one payment '(.*)'$")
    public void select_lv_one_payment(String payment) {
        blibliPurchaseItem.selectPaymentLevelOne(payment);
    }

    @When("^\\[ui] select lv two payment '(.*)'$")
    public void select_lv_two_payment(String payment) {
        blibliPurchaseItem.selectPaymentLevelTwo(payment);
    }

    @When("^\\[ui] pay using bayar sekarang button$")
    public void pay_using_bayar_sekarang_button() {
        blibliPurchaseItem.bayarSekarang();
    }

    //-------------- ASSERTIONS
    @Then("^\\[ui] assert that order is success")
    public void assert_that_order_is_success() {
        assertThat(blibliPurchaseItem.getOrderTitle().toLowerCase(), Matchers.containsString("terima kasih"));
    }
}
