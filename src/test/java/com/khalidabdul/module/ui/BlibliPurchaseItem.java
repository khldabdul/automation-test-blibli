package com.khalidabdul.module.ui;

import com.khalidabdul.module.ui.data.BlibliPageData;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class BlibliPurchaseItem extends PageObject {

    @FindBy(xpath = "//div[@class='kategori tooltip__trigger']")
    WebElementFacade categoryHover;

    @FindBy(xpath = "//div[contains(text(),'Official Store')]")
    WebElementFacade officialStoreCheckbox;

    @FindBy(xpath = "//div[@class='product__name-text']//h1")
    WebElementFacade productTitle;

    @FindBy(xpath = "//div[@class='buy-now__button']//div")
    WebElementFacade buyNowButton;

//    @FindBy(xpath = "//div[@class='add-to-cart__button']//div")
//    WebElementFacade addToCartButton;

    @FindBy(xpath = "//div[@class='quantity__field']//input")
    WebElementFacade quantityInput;

//    @FindBy(xpath = "//div[@class='cart__amt']")
//    WebElementFacade cartAmount;

    @FindBy(xpath = "//article[@class='ticker warning has-icon']")
    WebElementFacade notifWarning;

    @FindBy(xpath = "//button[@class='ticker__close b-order-right']")
    WebElementFacade notifWarningClose;

    @FindBy(xpath = "//div[@id='gdn-cart-button']//a")
    WebElementFacade cartButtonHover;

    @FindBy(xpath = "//div[@id='gdn-popup-shopping-bag']//a")
    WebElementFacade viewCart;

    @FindBy(xpath = "//input[@type='email']")
    WebElementFacade emailInput;

    @FindBy(xpath = "//input[@type='password']")
    WebElementFacade passwordInput;

//    @FindBy(xpath = "//a[@id='gdn-pnv-later']")
//    WebElementFacade phoneVerificationLater;
//
//    @FindBy(xpath = "//a[contains(text(), 'Lanjutkan')]")
//    WebElementFacade phoneVerificationLanjutkan;

    @FindBy(xpath = "//button[contains(text(),'Checkout')]")
    WebElementFacade checkoutButton;

    @FindBy(xpath = "//div[@class='summary ']//button")
    WebElementFacade checkoutLanjutButton;

    @FindBy(xpath = "//div[@id='payment-method-selection']//select")
    WebElementFacade paymentOption;

//    @FindBy(xpath = "//div[@id='payment-method-selection']//select//option")
//    WebElementFacade paymentOptionSelect;
//
//    @FindBy(xpath = "//input[@type='checkbox']")
//    WebElementFacade checkboxSNK;

    @FindBy(xpath = "//input[@id='gdn-submit-checkout']/parent::div")
    WebElementFacade bayarSekarang;

    @FindBy(xpath = "//div[@class='transfer-mandiri']//div[2]//strong[@class='layer-va']")
    WebElementFacade nomorVirtualAccount;

    @FindBy(xpath = "//span[@class='ordernumber']//strong")
    WebElementFacade orderNumber;

    @FindBy(xpath = "//h1")
    WebElementFacade orderTitle;

    @FindBy(xpath = "//label[@class='product-label']")
    List<WebElementFacade> orderProductTitle;

//    @FindBy(xpath = "//span[@class='product-quantity'][1]//strong")
//    List<WebElementFacade> orderProductAmount;

    @FindBy(xpath = "//ul[@class='purchase-summary']//li[1]//span[2]")
    WebElementFacade totalPurchase;

    String productCard = "//div//div[@class='product__card'][%s]";

    public void selectProductCard(String productNumber) {
        String xpath = String.format(productCard, productNumber);
        try {
            find(By.xpath(xpath)).click();
        }catch (org.openqa.selenium.StaleElementReferenceException ex) {
            find(By.xpath(xpath)).click();
        }
    }

    public void officialStoreCheckbox() {
        officialStoreCheckbox.waitUntilVisible();
        officialStoreCheckbox.click();
    }

    String selectCategoryLevelOne = "//a[@class='categories__menu-item'][contains(text(),'%s')]";

    String selectCategoryLevelTwo = "//div[@class='categories__item-block']//div//a[contains(text(),'%s')]";

    public void selectCategory(String categoryLvOne, String categoryLvTwo) {
        Actions a = new Actions(getDriver());
        String xpathOne = String.format(selectCategoryLevelOne, categoryLvOne);
        String xpathTwo = String.format(selectCategoryLevelTwo, categoryLvTwo);
        WebElementFacade webElementFacadeOne = find(By.xpath(xpathOne));
        WebElementFacade webElementFacadeTwo = find(By.xpath(xpathTwo));

        doNavigateToCategory();
        a.moveToElement(webElementFacadeOne).build().perform();
        webElementFacadeTwo.click();
    }

    String selectPaymentLevelOne = "//b[contains(text(),'%s')]";

    String selectPaymentLevelTwo = "//option[contains(text(),'%s')]";

    public void selectPaymentLevelOne(String payment) {
        String xpath = String.format(selectPaymentLevelOne, payment);
        WebElementFacade webElementFacade = find(By.xpath(xpath));
        webElementFacade.click();
    }

    public void selectPaymentLevelTwo(String payment) {
        paymentOption.click();

        String xpath = String.format(selectPaymentLevelTwo, payment);
        WebElementFacade webElementFacade = find(By.xpath(xpath));
        webElementFacade.click();
    }

    public void openHomePage() {
        openUrl("https://www.blibli.com/");
    }

    public void doNavigateToCategory() {
        Actions a = new Actions(getDriver());
        a.moveToElement(categoryHover).build().perform();
    }

    public void getProductTitle() {
        String title = productTitle.getText();
        System.out.println(title);
    }

    public void setQuantityInput(int qty) {
        Actions a = new Actions(getDriver());
        a.moveToElement(quantityInput).doubleClick().build().perform();
        quantityInput.sendKeys(String.valueOf(qty));
        buyNow();
    }

    public void buyNow() {
        try {
            buyNowButton.click();
        }catch (org.openqa.selenium.NoSuchElementException ex) {
            buyNowButton.click();
        }
    }

    public void doLogin() {
        emailInput.type(BlibliPageData.getEmail());
        passwordInput.typeAndEnter(BlibliPageData.getPassword());
    }

    public void closeNotif() {
        if (notifWarning.isVisible()) {
            notifWarningClose.click();
        }else {
            System.out.println("there is no notification shown up.");
        }
    }

    public void goToCart() {
        Actions a = new Actions(getDriver());
        try {
            closeNotif();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            System.out.println("there is no notification.");
        }
        a.moveToElement(cartButtonHover).build().perform();
        viewCart.click();
    }

    public void checkout() {
        try {
            checkoutButton.waitUntilPresent().click();
            checkoutLanjutButton.waitUntilPresent().click();
        }catch (org.openqa.selenium.StaleElementReferenceException ex) {
            checkoutButton.waitUntilPresent().click();
            checkoutLanjutButton.waitUntilPresent().click();
        }
    }

    public void bayarSekarang() {
        bayarSekarang.click();
    }

    public String getOrderTitle() {
        try {
            String title = orderTitle.getText();
            System.out.println(title);
            orderSuccess();
            return title;
        }catch (org.openqa.selenium.ElementNotVisibleException ex) {
            String title = orderTitle.getText();
            System.out.println(title);
            orderSuccess();
            return title;
        }
    }

    public void getOrderProduct() {
        List<String> list = new ArrayList<>();
        for (WebElementFacade webElementFacade : orderProductTitle) {
            list.add(webElementFacade.getText());
        }
        list.forEach((temp) -> System.out.println("Nama Produk: " + temp));
    }

    public void orderSuccess() {
        getOrderProduct();
        System.out.println("Jumlah Harga: " + totalPurchase.getText());
        System.out.println("Nomor Virtual Account: " + nomorVirtualAccount.getText());
        System.out.println("Nomor Pesanan: " + orderNumber.getText());
    }

}
