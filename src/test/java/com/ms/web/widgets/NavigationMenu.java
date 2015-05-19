package com.ms.web.widgets;
import com.ms.web.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by frank on 19/05/2015.
 */
public class NavigationMenu {
    private WebDriver driver;
    @FindBy(id = "main-nav")
    private WebElement mainNavMenu;

    public NavigationMenu(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectMenuItem(final String txt, final String subTxt) {
        WebElement level1Menu =  mainNavMenu.findElement(By.xpath(String.format("//*[text()= '%s']", txt)));
        Actions action = new Actions(driver);
        action.moveToElement(level1Menu).build().perform();
        WebElement level2Menu = mainNavMenu.findElement(By.linkText(subTxt));
        level2Menu.click();
    }
}
