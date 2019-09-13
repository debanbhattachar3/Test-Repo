package com.debanjan.webdriver2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MouseHover {

    WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        //webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        webDriver.get("https://www.amazon.in/");
        WebElement shop_by = webDriver.findElement(By.xpath("//div[@id='nav-shop']//a[@id='nav-link-shopall']"));

        //mouse hover action
        Actions actions = new Actions(webDriver);
        actions.moveToElement(shop_by).build().perform();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement woman_fashion = webDriver.findElement(By.xpath("//span[contains(@class,'nav-item')]//span[contains(@class,'nav-text')][contains(text(),\"Women's Fashion\")]"));
        //Explicit wait
//        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 20);
//        webDriverWait.until(ExpectedConditions.visibilityOf(woman_fashion));

        woman_fashion.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }


}
