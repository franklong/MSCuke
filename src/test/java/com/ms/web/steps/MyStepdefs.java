package com.ms.web.steps;

import com.ms.web.config.Config;
import com.ms.web.pages.ProductItemPage;
import com.ms.web.pages.ProductListingPage;
import com.ms.web.pages.ViewBagPage;
import com.ms.web.widgets.NavigationMenu;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by frank on 19/05/2015.
 */

public class MyStepdefs {
    private String itemDescription;
    ProductItemPage productItemPage;
    ViewBagPage viewBagPage;

    @Given("^I have added a shirt to my bag$")
    public void I_have_added_a_shirt_to_my_bag() throws Throwable {
        NavigationMenu navigationMenu = new NavigationMenu(Config.driver);
        navigationMenu.selectMenuItem("Men", "Casual Shirts");
        ProductListingPage productListingPage = new ProductListingPage(Config.driver);
        productItemPage = productListingPage.selectProduct(0);
        productItemPage.selectSwatch(0);
        productItemPage.selectSmallSize();
        productItemPage.addToBasket();
        itemDescription = productItemPage.getItemTitle();
    }

    @When("^I view the contents of my bag$")
    public void I_view_the_contents_of_my_bag(){
        viewBagPage = productItemPage.clinkOnViewBag();
    }

    @Then("^I can see the contents of the bag include a shirt$")
    public void I_can_see_the_contents_of_the_bag_include_a_shirt() {
        System.out.println(itemDescription);
        Assert.assertTrue(viewBagPage.hasItemInList(itemDescription));
    }
}
