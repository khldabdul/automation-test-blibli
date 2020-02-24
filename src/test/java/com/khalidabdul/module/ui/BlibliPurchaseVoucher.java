package com.khalidabdul.module.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class BlibliPurchaseVoucher extends PageObject {

    // ================ ORDER PAGE
    @FindBy(xpath = "//div[@class='favourite__header']//a")
    WebElementFacade seeAll;

    @FindBy(xpath = "//div[@class='form__row-3']//input")
    WebElementFacade nominalInput;

    @FindBy(xpath = "//div[@class='form__row-3']//div//div")
    WebElementFacade nominalInputOption;

    @FindBy(xpath = "//div[@class='form__result-btn']")
    WebElementFacade continueToPayment;


    // ================ LOGIN POP UP
    @FindBy(xpath = "//input[@id='member2']/following-sibling::label")
    WebElementFacade blibliMemberRadioButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElementFacade emailInput;

    @FindBy(xpath = "//input[@type='password']")
    WebElementFacade passwordInput;

    @FindBy(xpath = "//button[@class='button-submit']")
    WebElementFacade buttonSubmit;


    // ================ PAYMENT
    @FindBy(xpath = "//button[@class='payment__buyNow']")
    WebElementFacade paymentBuyNow;

    @FindBy(xpath = "//div[@class='select__content togel']")
    WebElementFacade paymentOption;


    // ================ THANK YOU PAGE
    @FindBy(xpath = "//div[@class='thankyou__info']")
    WebElementFacade paymentStatus;

    @FindBy(xpath = "//div[@class='thankyou__product--summary']//div[2]")
    WebElementFacade voucherName;

//    @FindBy(xpath = "//div[@class='thankyou__product--summary']//div[4]")
//    WebElementFacade voucherAmount;

    @FindBy(xpath = "//div[@class='thankyou__order']//tr[1]//td[3]")
    WebElementFacade orderNumber;

    @FindBy(xpath = "//div[@class='thankyou__order']//tr[2]//td[3]")
    WebElementFacade paymentMethod;

    @FindBy(xpath = "//div[@class='thankyou__order']//tr[3]//td[3]")
    WebElementFacade totalAmount;

    @FindBy(xpath = "//div[@class='thankyou__payment-code--code']")
    WebElementFacade virtualAccNumber;


    // ================ CATEGORY
    public void seeAllCategory() {
        seeAll.click();
    }

    // ================ CATEGORY SELECT
    String categoryLvOne = "//div[@class='tabs__header']//a[contains(text(),'%s')]";

    public void selectCategoryLvOne(String category) {
        String xpath = String.format(categoryLvOne, category);
        WebElementFacade webElementFacade = find(By.xpath(xpath));
        webElementFacade.click();
    }

    String categoryLvTwo = "//div[contains(text(),'%s')]/parent::div";

    public void selectCategoryLvTwo(String category) {
        String xpath = String.format(categoryLvTwo, category);
        WebElementFacade webElementFacade = find(By.xpath(xpath));
        webElementFacade.click();
    }

    String gameCreditVoucher = "//span[contains(text(),'%s')]/parent::div";

    public void selectGameCreditVoucher(String value) {
        String xpath = String.format(gameCreditVoucher, value);
        find(By.xpath(xpath)).click();
    }

    public void selectNominal(int index) {
        nominalInput.click();

        for (int i = 0; i < index; i++) {
            nominalInput.sendKeys(Keys.ARROW_DOWN);
        }   nominalInput.sendKeys(Keys.ENTER);

//        Select nominal = new Select(getDriver().findElement(By.xpath(String.valueOf(nominalInputOption))));
//        nominal.selectByIndex(index);
    }

    public void doContinueToPayment() {
        continueToPayment.click();
    }


    // ================ PAYMENT SELECT
    String selectPaymentLevelOne = "//span[contains(text(),'%s')]";

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

    public void doLogin(String email, String password) {
        blibliMemberRadioButton.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        buttonSubmit.click();
    }

    public void doPaymentBuyNow() {
        paymentBuyNow.click();
    }

    public String isPaymentSuccess() {
        String title = paymentStatus.getText();
        System.out.println(title);
        return title;
    }

    public void orderSuccess() {
        System.out.println("Name: " + voucherName.getText());
//        System.out.println("Voucher Amount: " + voucherAmount.getText());
        System.out.println("Order Number: " + orderNumber.getText());
        System.out.println("Payment Method: " + paymentMethod.getText());
        System.out.println("Total Payment: " + totalAmount.getText());
        System.out.println("Virtual Account No.: " + virtualAccNumber.getText());
    }
}
