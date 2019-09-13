package com.debanjan.selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChromeOption {

    WebDriver webDriver;

    public void verifyChromeOption() {

        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);

        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://invalid-expected-sct.badssl.com/");

        //verify the title
        String title = webDriver.getTitle();
        Assert.assertEquals(title, "invalid-expected-sct.badssl.com", "Title not matched! ");

    }


    public void headlessBrowser() {
        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        webDriver = new ChromeDriver(chromeOptions);

        webDriver.get("https://www.google.com/");
        //verify the title
        String title = webDriver.getTitle();
        Assert.assertEquals(title, "Google", "Title not matched! ");

    }

    @Test
    public void addArguments() {
        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-infobars");

        webDriver = new ChromeDriver(chromeOptions);

        webDriver.get("https://www.google.com/");
        //verify the title
        String title = webDriver.getTitle();
        Assert.assertEquals(title, "Google", "Title not matched! ");
        webDriver.quit();
    }

    @Test
    public void disableNotification() throws InterruptedException {
        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        webDriver = new ChromeDriver(chromeOptions);

        //get the url
        webDriver.get("https://www.easemytrip.com/");
        String title = webDriver.getTitle();
        Assert.assertEquals(title, "Book Flights, Hotels, Bus Tickets & Holidays - EaseMyTrip.com", "Title not matched.");
        Thread.sleep(3000);
        webDriver.quit();
    }
}
