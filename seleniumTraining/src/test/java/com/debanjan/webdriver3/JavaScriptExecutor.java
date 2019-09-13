package com.debanjan.webdriver3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        //webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void test1() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("window.location='https://www.google.com'");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //get the title
        String title = (String) javascriptExecutor.executeScript("return document.title");
        System.out.println("Title is : " + title);

        //type some value
        WebElement search_text = webDriver.findElement(By.xpath("//input[@title='Search']"));
        javascriptExecutor.executeScript("arguments[0].value='selenium'", search_text);

        //click on the search button
        WebElement search_button = webDriver.findElement(By.xpath("(//input[@name='btnK'][@class='gNO89b'])[1]"));
        javascriptExecutor.executeScript("arguments[0].click()", search_button);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test2(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("window.location='http://makeseleniumeasy.com/2017/07/14/how-to-handle-a-web-table-in-selenium-webdriver/'");

        javascriptExecutor.executeScript("window.scrollBy(0,4000)");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement last = webDriver.findElement(By.linkText("Mystery Themes"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",last);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
