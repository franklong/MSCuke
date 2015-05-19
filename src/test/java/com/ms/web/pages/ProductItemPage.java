package com.ms.web.pages;

import com.ms.web.steps.MyStepdefs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by frank on 19/05/2015.
 */
public class ProductItemPage {
    private WebDriver driver;

    /*The following selectors are should be replaced with ids to increase testability of the site*/

    @FindBy(xpath = "//input[@class='basket']")
    private WebElement addToBasket;

    @FindBy(css = "td.low-stock > label")
    private WebElement smallSize;

    @FindBy(css = " a.header-link")
    private WebElement viewBagHeaderLink;

    @FindBy(xpath = "//h1")
    private WebElement itemDescription;

    public ProductItemPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToBasket() {
        addToBasket.click();
    }

    public void selectSwatch(int index) throws InterruptedException {
        List<WebElement> colours = driver.findElements(By.xpath("//*[@id='swatch']//input[@type='radio']"));
        colours.get(index).click();
    }

    public void selectSmallSize(){
        smallSize.click();
    }

    public ViewBagPage clinkOnViewBag(){
        viewBagHeaderLink.click();
        return PageFactory.initElements(driver, ViewBagPage.class);
    }

    public String getItemTitle(){
        return itemDescription.getText();
    }
}
