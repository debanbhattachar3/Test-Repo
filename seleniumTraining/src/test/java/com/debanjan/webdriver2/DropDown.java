package com.debanjan.webdriver2;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDown {
    WebDriver webDriver = null;

    @BeforeMethod
    public void beforeMethod() {
        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver76.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open URL
        webDriver.get("https://www.facebook.com");
    }

    @Test
    public void test1() {
        WebElement month_dropdown = webDriver.findElement(By.xpath("//select[@id='month']"));
        Select select = new Select(month_dropdown);

        //select by index
        System.out.println("Is drop down list multi selected? " + select.isMultiple());
        select.selectByIndex(3);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        select.selectByValue("6");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        select.selectByVisibleText("Dec");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }
}
