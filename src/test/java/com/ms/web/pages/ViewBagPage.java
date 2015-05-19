package com.ms.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by frank on 19/05/2015.
 */
public class ViewBagPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@class='basket']")
    private WebElement addToBasket;

    public ViewBagPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean hasItemInList(final String text){
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) {
           if(element.getText().equals(text));
            return true;
        }
        return false;
    }


}
