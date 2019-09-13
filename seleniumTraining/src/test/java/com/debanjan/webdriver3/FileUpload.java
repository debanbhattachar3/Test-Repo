package com.debanjan.webdriver3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {
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
        webDriver.get("https://the-internet.herokuapp.com/upload");
        WebElement fileUpload = webDriver.findElement(By.id("file-upload"));
        WebElement upload_btn = webDriver.findElement(By.id("file-submit"));

        fileUpload.sendKeys("C:/Users/debanbhattachar3/Desktop/MR43/page list 3.png");
        upload_btn.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(webDriver.findElement(By.xpath("(//h3)[1]")).getText());

    }
}
