package com.debanjan.webdriver1;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InsideWebElement {
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
        webDriver.get("https://www.ndtv.com/");
    }

    @Test
    public void test1() {
        WebElement top_story = webDriver.findElement(By.xpath("//div[@class='cont_cmn top-stories-68']"));
        List<WebElement> list_elements = top_story.findElements(By.tagName("a"));
        //List<WebElement> list_elements = top_story.findElements(By.xpath("//a[text()]"));
        System.out.println("Total Links :  " + list_elements.size());
        for (WebElement webElement : list_elements) {
            if (!webElement.getText().isEmpty()) {
                System.out.println("Value : " + webElement.getText());
            }

        }
    }


    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }
}
