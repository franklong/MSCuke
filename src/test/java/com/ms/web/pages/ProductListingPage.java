package com.ms.web.pages;

import com.ms.web.widgets.NavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by frank on 19/05/2015.
 */
public class ProductListingPage {
    private WebDriver driver;
    @FindBy(id = "product-listing")
    private WebElement productList;

    public ProductListingPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductItemPage selectProduct(int index) {
        List<WebElement> products = driver.findElements(By.className("product-view"));
        products.get(index).click();
        return PageFactory.initElements(driver, ProductItemPage.class);
    }
}
