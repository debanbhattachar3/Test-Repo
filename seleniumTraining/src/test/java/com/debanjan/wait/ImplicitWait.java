package com.debanjan.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    WebDriver webDriver = null;

    @Test
    public void testImplicitWait() {
        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");

        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        //Implicitly wait time for 30 seconds
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        //open google and search
        webDriver.get("https://www.google.com");
        WebElement searchBox = webDriver.findElement(By.xpath("//input[@title='Search']"));

        searchBox.sendKeys("Selenium Download");

        WebElement option6 = webDriver.findElement(By.xpath("//li[@class='sbct'][4]"));
        option6.click();

        webDriver.quit();
    }
}
