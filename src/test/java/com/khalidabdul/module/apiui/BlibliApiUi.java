package com.khalidabdul.module.apiui;

import com.khalidabdul.module.api.data.ApiData;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class BlibliApiUi extends PageObject {

    String size = "//span[contains(text(),'%s')]/parent::div";

    public void selectSize(String value) {
        String xpath = String.format(size, value);
        find(By.xpath(xpath)).click();
    }

    public void openPage() {
        openUrl("https://www.blibli.com" + ApiData.getUrlProduct());
        System.out.println("https://www.blibli.com" + ApiData.getUrlProduct());
    }

}
