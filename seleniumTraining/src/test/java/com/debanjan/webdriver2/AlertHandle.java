package com.debanjan.webdriver2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertHandle {

    WebDriver webDriver = null;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //webDriver = new FirefoxDriver();
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test1() {
        //open URL
        webDriver.get("https://www.rediff.com/");
        System.out.println("Window handle ID is : " + webDriver.getWindowHandle());
        //click on the email button
        webDriver.findElement(By.xpath("//a[@title='Lightning fast free email']")).click();
        WebElement username = webDriver.findElement(By.xpath("//div//input[@id='login1']"));
        username.sendKeys("test@test.com");
        //click on the ok button
        webDriver.findElement(By.xpath("//div//input[@title='Sign in']")).click();

        /*
        Handle the alert here
         */
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 30);
        webDriverWait.until(ExpectedConditions.alertIsPresent());

        Alert alert = webDriver.switchTo().alert();
        System.out.println("Get the text of the alert : " + alert.getText());
        alert.dismiss();


        //enter the password
        WebElement password = webDriver.findElement(By.xpath("//div//input[@id='password']"));
        password.sendKeys("abc@123");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

}
