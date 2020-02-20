package com.khalidabdul.module.apiui;

import com.khalidabdul.module.api.ApiController;
import net.serenitybdd.core.pages.PageObject;

public class BlibliApiUi extends PageObject {

    ApiController apiController;

    public void openPage() {
        openUrl("https://www.blibli.com/");
    }
}
