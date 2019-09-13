package com.debanjan.webelement;

import com.debanjan.selenium.ChromeOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FindElementTest {

    WebDriver webDriver;

    @Test
    public void test1(){
        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-infobars");

        webDriver = new ChromeDriver(chromeOptions);

        webDriver.get("https://freecrm.com/");

        WebElement signInButton = webDriver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']"));
        signInButton.click();

        webDriver.findElement(By.className("ui left icon input")).sendKeys("debanjan@gmail.com");
        webDriver.findElement(By.className("ui left icon input")).sendKeys("password123");
        //wait for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webDriver.quit();
    }
}
