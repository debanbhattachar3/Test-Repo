package com.debanjan.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserStart {


    @Test
    public void openBrowser() {

        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com");
        String title = webDriver.getTitle();

        Assert.assertEquals(title, "Google", "Title not matched. ");

        webDriver.close();


    }
}
