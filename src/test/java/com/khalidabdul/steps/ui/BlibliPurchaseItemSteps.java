package com.khalidabdul.steps.ui;

import com.khalidabdul.module.ui.BlibliPurchaseItem;
import cucumber.api.java.en.Given;
import net.thucydides.core.steps.ScenarioSteps;

public class BlibliPurchaseItemSteps extends ScenarioSteps {

    BlibliPurchaseItem blibliPurchaseItem;

    //-------------- PREPARATION
    @Given("^\\[ui] blibli page for purchase is opened$")
    public void blibli_page_is_opened() {
        blibliPurchaseItem.openHomePage();
    }

    //-------------- ACTIONS

    //-------------- ASSERTIONS
}
