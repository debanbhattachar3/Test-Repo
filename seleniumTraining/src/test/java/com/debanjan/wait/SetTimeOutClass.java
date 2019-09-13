package com.debanjan.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SetTimeOutClass {

    WebDriver webDriver = null;

    @Test
    public void setTimeOutTest(){
        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");

        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        //set the page load time out
        webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        webDriver.get("https://edition.cnn.com/");

        webDriver.quit();

    }
}
