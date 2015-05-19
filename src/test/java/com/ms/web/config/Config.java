package com.ms.web.config;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by frank on 19/05/2015.
 */

public class Config {
    public static final String URL = "http://www.marksandspencer.com";
    public static WebDriver driver;

    @Before
    public void before() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Config.URL);
    }

    @After
    public void after() {
        driver.close();
        driver.quit();
    }
}
