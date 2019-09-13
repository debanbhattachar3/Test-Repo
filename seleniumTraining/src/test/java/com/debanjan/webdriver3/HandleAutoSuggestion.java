package com.debanjan.webdriver3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HandleAutoSuggestion {
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
    public void test1(){
        webDriver.get("https://www.google.com");
        webDriver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");

        WebDriverWait webDriverWait = new WebDriverWait(webDriver,20);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(webDriver.findElements(By.xpath("//ul/li[@class='sbct'][@data-view-type='1']"))));


        //get all the auto suggestion value
        List<WebElement> suggestions = webDriver.findElements(By.xpath("//ul/li[@class='sbct'][@data-view-type='1']"));
        System.out.println("Total suggestion : " + suggestions.size());
        for(WebElement suggestion : suggestions){
            System.out.println(suggestion.getText());
        }
    }
}
