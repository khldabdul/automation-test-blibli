package com.khalidabdul.module.ui;

import com.khalidabdul.module.ui.data.BlibliPageData;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//a[@class='categories__menu-item'][contains(text(),'Komputer & Laptop')]")
    WebElementFacade categoryHoverKomputer;

    @FindBy(xpath = "//a[@class='categories__menu-item'][contains(text(),'Kamera')]")
    WebElementFacade categoryHoverKamera;

    @FindBy(xpath = "//div[@class='categories__item-block'][4]//div//a[contains(text(),'Gaming Audio')]")
    WebElementFacade gamingAudio;

    @FindBy(xpath = "//div[@class='categories__item-block'][1]//div//a[contains(text(),'Kamera Mirrorless')]")
    WebElementFacade kameraMirrorless;

    @FindBy(xpath = "//h1")
    WebElementFacade categoryTitle;

    @FindBy(xpath = "//div[@class='buy-now__button']//div")
    WebElementFacade buyNowButton;

    @FindBy(xpath = "//div[@class='add-to-cart__button']//div")
    WebElementFacade addToCartButton;

    @FindBy(xpath = "//body//div[@class='recommended-product']//div//div[2]//a[1]")
    WebElementFacade recommendedProduct;

    @FindBy(xpath = "//div[@class='flashsale']//div[@class='moving items']//div[3]//div[1]//a[1]")
    WebElementFacade flashSaleProduct;

    @FindBy(xpath = "//div[@class='quantity__field']//input")
    WebElementFacade quantityInput;

    @FindBy(xpath = "//div[@id='gdn-cart-button']")
    WebElementFacade cartButtonHover;

    @FindBy(xpath = "//div[@id='gdn-popup-shopping-bag']//a")
    WebElementFacade viewCart;

    @FindBy(xpath = "//button[contains(text(),'Checkout')]")
    WebElementFacade checkoutButton;

    @FindBy(xpath = "//div[@class='summary ']//button")
    WebElementFacade checkoutLanjutButton;

    @FindBy(xpath = "//select[@id='gdn-payment-option-']")
    WebElementFacade paymentOption;

    String selectPaymentLevelOne = "//b[contains(text(),'%s')]";

    String SelectPaymentLevelTwo = "//option[contains(text(),'%s')]";

    public void selectPaymentLevelOne(String payment) {
        String xpath = String.format(selectPaymentLevelOne, payment);
        WebElementFacade webElementFacade = find(By.xpath(xpath));
        webElementFacade.click();
    }

    public void selectPaymentLevelTwo(String payment) {
        String xpath = String.format(SelectPaymentLevelTwo, payment);
        find(By.xpath(xpath)).click();
    }

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

    public void doNavigateToCategory() {
        Actions a = new Actions(getDriver());
         a.moveToElement(categoryHover).build().perform();
    }

    public void goToGamingAudio() {
        Actions a = new Actions(getDriver());
        a.moveToElement(categoryHoverKomputer).build().perform();
        gamingAudio.waitUntilPresent().click();
    }

    public void goToKameraMirrorless() {
        Actions a = new Actions(getDriver());
        a.moveToElement(categoryHoverKamera).build().perform();
        kameraMirrorless.waitUntilPresent().click();
    }

    public String getCategoryTitle() {
        String title = categoryTitle.getText();
        return title;
    }

}
