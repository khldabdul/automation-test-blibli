package com.khalidabdul.module.ui;

import com.khalidabdul.module.ui.data.BlibliPageData;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.List;

public class BlibliPage extends PageObject {

    @FindBy(xpath = "//input[@name='search']")
    WebElementFacade searchBox;

    @FindBy(xpath = "//span[@class='product__title__name']")
    List<WebElementFacade> productNameData;

    @FindBy(xpath = "//div[@class='kategori tooltip__trigger']")
    WebElementFacade categoryHover;

    @FindBy(xpath = "//a[@class='categories__menu-item'][contains(text(),'Komputer & Laptop')]")
    WebElementFacade komputerCategoryHover;

    @FindBy(xpath = "//div[@class='categories__item-block'][4]//div//a[contains(text(),'Gaming Audio')]")
    WebElementFacade gamingAudioHover;

    @FindBy(xpath = "//div[@class='sub-category-banner-hover']//div[2]//div[2]")
    WebElementFacade gamingCategoryHover;

    @FindBy(xpath = "//a[@target='$IMAGE_5_TARGET']")
    WebElementFacade gamingHeadsetButton;

    public void openHomePage() {
        openUrl("https://www.blibli.com/");
    }

    public void doSearch() {
        searchBox.typeAndEnter(BlibliPageData.getKeyword());
    }

    public List<String> getProductNameData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < productNameData.size(); i++) {
            list.add(productNameData.get(i).getText());
        }
        return list;
    }

    public void doNavigateToCategory() throws InterruptedException {
        Actions a = new Actions(getDriver());
         a.moveToElement(categoryHover).build().perform();
         Thread.sleep(2000);
//         waitForElement().until((ExpectedCondition<? extends WebElement>) waitForRenderedElementsToBePresent((By) komputerCategoryHover));
         a.moveToElement(komputerCategoryHover).build().perform();
//         waitForElement().until((ExpectedCondition<? extends WebElement>) waitForRenderedElementsToBePresent((By) gamingAudioHover));
         gamingAudioHover.click();

    }
}
