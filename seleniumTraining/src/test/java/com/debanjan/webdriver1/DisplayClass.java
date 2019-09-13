package com.debanjan.webdriver1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DisplayClass {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open URL
        webDriver.get("https://jqueryui.com/");
    }

    @Test
    public void isDisplayTest() {
        WebElement toggle = webDriver.findElement(By.xpath("//a[contains(text(),'Toggle')]"));
        toggle.click();

        //move to the iframe
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        //check before effect button
        WebElement toggleCheck = webDriver.findElement(By.xpath("//div[@id='effect']"));
        Assert.assertTrue(toggleCheck.isDisplayed());

        //Click on the effect button
        WebElement effectBtn = webDriver.findElement(By.xpath("//button[@class='ui-state-default ui-corner-all']"));
        effectBtn.click();

        //Explicit wait to verify that 
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.invisibilityOf(toggleCheck));


        //check after clicking on the effect button
        Assert.assertFalse(toggleCheck.isDisplayed());
        Assert.assertTrue(toggleCheck.isSelected());

    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }
}
