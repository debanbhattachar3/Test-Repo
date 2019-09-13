package com.debanjan.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DynamicInvokeBrowser {


    WebDriver webDriver = null;

    @Parameters({"browser", "test"})
    @BeforeMethod
    public void driverSetUp(String browserName, String test) {
        System.out.println("Printing the test value " + test);
        if (browserName.equalsIgnoreCase("chrome")) {
            String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driver_path);
            webDriver = new ChromeDriver();
            System.out.println("===============================================");
            System.out.println("Chrome driver set up");
            System.out.println("===============================================");
        } else if (browserName.equalsIgnoreCase("firefox") || browserName.equalsIgnoreCase("mozila")) {
            String driver_path = System.getProperty("user.dir") + "/src/drivers/geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", driver_path);
            webDriver = new FirefoxDriver();
            System.out.println("===============================================");
            System.out.println("Firefox driver set up");
            System.out.println("===============================================");
        } else if (browserName.equalsIgnoreCase("ie")) {
            String driver_path = System.getProperty("user.dir") + "/src/drivers/IEDriverServer.exe";
            System.setProperty("webdriver.ie.driver", driver_path);
            webDriver = new InternetExplorerDriver();
            System.out.println("===============================================");
            System.out.println("Chrome driver set up");
            System.out.println("===============================================");
        } else {
            String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driver_path);
            webDriver = new ChromeDriver();
            System.out.println("===============================================");
            System.out.println("Browser name is not correct ; default Chrome browser is set up");
            System.out.println("===============================================");
        }

        //maximize the browser window
        webDriver.manage().window().maximize();
    }

    @Test
    public void titleMatchTest() {
        webDriver.get("https://www.google.com");
        String title = webDriver.getTitle();
        Assert.assertEquals(title, "Google", "Title not matched. ");
    }

    @AfterTest
    public void closeTest() {
        webDriver.quit();
    }
}
