package com.khalidabdul.steps.apiui;

import com.khalidabdul.module.apiui.BlibliApiUi;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

public class BlibliApiUiSteps extends ScenarioSteps {

    private static BlibliApiUi blibliApiUi;

    // GIVEN

    // WHEN
    @When("^\\[ui] product page is opened$")
    public static void product_page_is_opened () {
        blibliApiUi.openPage();
    }

    @When("^\\[ui] select size of '(.*)'$")
    public static void select_size (String value) {
        blibliApiUi.selectSize(value);
    }

    // THEN

}
