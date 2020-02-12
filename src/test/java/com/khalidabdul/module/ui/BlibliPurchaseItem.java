package com.khalidabdul.module.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class BlibliPurchaseItem extends PageObject {

    @FindBy(xpath = "//div[@class='buy-now__button']//div")
    WebElementFacade buyNowButton;

    @FindBy(xpath = "//div[@class='add-to-cart__button']//div")
    WebElementFacade addToCartButton;

    @FindBy(xpath = "//div[@class='quantity__field']//input")
    WebElementFacade quantityInput;

    @FindBy(xpath = "//div[@class='cart__amt']")
    WebElementFacade cartAmount;

    @FindBy(xpath = "//div[@id='gdn-cart-button']")
    WebElementFacade cartButtonHover;

    @FindBy(xpath = "//div[@id='gdn-popup-shopping-bag']//a")
    WebElementFacade viewCart;

    @FindBy(xpath = "//input[@type='email']")
    WebElementFacade emailInput;

    @FindBy(xpath = "//input[@type='password']")
    WebElementFacade passwordInput;

    @FindBy(xpath = "//a[@id='gdn-pnv-later']")
    WebElementFacade phoneVerificationLater;

    @FindBy(xpath = "//a[contains(text(), 'Lanjutkan')]")
    WebElementFacade phoneVerificationLanjutkan;

    @FindBy(xpath = "//button[contains(text(),'Checkout')]")
    WebElementFacade checkoutButton;

    @FindBy(xpath = "//div[@class='summary ']//button")
    WebElementFacade checkoutLanjutButton;

    @FindBy(xpath = "//select[@id='gdn-payment-option-']")
    WebElementFacade paymentOption;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElementFacade checkboxSNK;

    @FindBy(xpath = "//input[@id='gdn-submit-checkout']")
    WebElementFacade bayarSekarang;

    @FindBy(xpath = "//div[@class='transfer-mandiri']//div[2]//strong[@class='layer-va']")
    WebElementFacade nomorVirtualAccount;

    @FindBy(xpath = "//span[@class='ordernumber']//strong")
    WebElementFacade orderNumber;

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

}
