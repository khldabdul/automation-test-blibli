package com.khalidabdul.module.ui;

import com.khalidabdul.module.ui.data.BlibliPageData;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//div[@class='product__filter']//select[@class='select']")
    WebElementFacade productFilter;

    @FindBy(xpath = "//select[@class='select']//option")
    List<WebElementFacade> filterOption;

    @FindBy(xpath = "//span[@class=\"product__body__price__slashed-percentage\"]")
    List<WebElementFacade> discountValue;

    String selectFilter = "//option[contains(text(),'%s')]";

    public void selectFilter(String filter) {
        String xpath = String.format(selectFilter, filter);

        System.out.println(find(By.xpath(xpath)).waitUntilPresent().getText());
        find(By.xpath(xpath)).waitUntilPresent().sendKeys(Keys.ENTER);
    }

    public List<String> getFilterOption() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < filterOption.size(); i++) {
            list.add(filterOption.get(i).getText());
        }
        return list;
    }

    public void selectFilterOption(String filter) {
        productFilter.click();
        productFilter.sendKeys(Keys.ARROW_DOWN);
        productFilter.sendKeys(Keys.ENTER);
        for (int i = 0; i < getFilterOption().size(); i++) {
            if (getFilterOption().get(i).equalsIgnoreCase(filter)) {
                break;
            }else {
                productFilter.sendKeys(Keys.ARROW_DOWN);
            }
        }
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

    public void goToKameraMirrorless() {
        Actions a = new Actions(getDriver());
        a.moveToElement(categoryHoverKamera).build().perform();
        kameraMirrorless.waitUntilPresent().click();
    }

    public String getCategoryTitle() {
        String title = categoryTitle.getText();
        return title;
    }

    public List<Integer> getDiscountValue() {
        List<String> listString = new ArrayList<>();
        for (int i = 0; i < discountValue.size(); i++) {
            listString.add(discountValue.get(i).getText().replaceAll("\\D+",""));
        }
//        System.out.println(listString);
        List<Integer> list = new ArrayList<>(listString.size());
        for (String i : listString) {
            list.add(Integer.valueOf(i));
        }

        System.out.println(list);
        return list;
    }

}
