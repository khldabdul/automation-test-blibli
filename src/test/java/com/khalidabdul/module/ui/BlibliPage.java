package com.khalidabdul.module.ui;

import com.khalidabdul.module.ui.data.BlibliPageData;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class BlibliPage extends PageObject {

    @FindBy(xpath = "//input[@name='search']")
    WebElementFacade searchBox;

    @FindBy(xpath = "//span[@class='product__title__name']")
    List<WebElementFacade> productNameData;

    @FindBy(xpath = "//div[@class='kategori tooltip__trigger']")
    WebElementFacade categoryHover;

    @FindBy(xpath = "//a[@class='categories__menu-item'][contains(text(),'Kamera')]")
    WebElementFacade categoryHoverKamera;

    @FindBy(xpath = "//div[@class='categories__item-block'][1]//div//a[contains(text(),'Kamera Mirrorless')]")
    WebElementFacade kameraMirrorless;

    @FindBy(xpath = "//h1")
    WebElementFacade categoryTitle;

    public void openHomePage() {
        openUrl("https://www.blibli.com/");
    }

    public void doSearch() {
        searchBox.typeAndEnter(BlibliPageData.getKeyword());
    }

    public List<String> getProductNameData() {
        List<String> list = new ArrayList<>();
        for (WebElementFacade productNameDatum : productNameData) {
            list.add(productNameDatum.getText());
        }
        return list;
    }

    public void doNavigateToCategory() {
        Actions a = new Actions(getDriver());
        a.moveToElement(categoryHover).build().perform();
    }

    public void goToKameraMirrorless() {
        Actions a = new Actions(getDriver());
        a.moveToElement(categoryHoverKamera).build().perform();
        kameraMirrorless.waitUntilEnabled().click();
    }

    public String getCategoryTitle() {
        return categoryTitle.getText();
    }

}
