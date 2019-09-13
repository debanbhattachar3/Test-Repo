package com.debanjan.webdriver1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameHandle {

    WebDriver webDriver = null;

    @Test
    public void frameTest() {
        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");

        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();

        //open URL
        webDriver.get("https://jqueryui.com/");


        //Click on any option
        WebElement btnLink = webDriver.findElement(By.xpath("//li//a[contains(text(),'Button')]"));
        btnLink.click();

        //click on any iframe button
        //Move to the iframe
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[contains(@src,'/resources')]")));
        WebElement submitBtn = webDriver.findElement(By.xpath("//input[@class='ui-button ui-corner-all ui-widget']"));
        String btnText = submitBtn.getAttribute("value");
        Assert.assertEquals(btnText, "A submit button");

        //move back to parent window
        webDriver = webDriver.switchTo().parentFrame();
        WebElement header = webDriver.findElement(By.xpath("//div//h1[@class='entry-title']"));
        String headerValue = header.getText();
        Assert.assertEquals(headerValue, "Button");

        webDriver.quit();

    }


}
