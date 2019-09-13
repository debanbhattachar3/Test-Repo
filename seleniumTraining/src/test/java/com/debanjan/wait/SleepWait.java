package com.debanjan.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SleepWait {

    WebDriver webDriver = null;

    @Test
    public void googleTest() {
        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");

        webDriver = new ChromeDriver(chromeOptions);

        //open google and search
        webDriver.get("https://www.google.com");
        WebElement searchBox = webDriver.findElement(By.xpath("//input[@title='Search']"));

        searchBox.sendKeys("Selenium Download");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebElement option6 = webDriver.findElement(By.xpath("//li[@class='sbct'][4]"));
        option6.click();

        webDriver.quit();


    }

}
