package com.debanjan.webdriver3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        //webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        webDriver.get("http://makeseleniumeasy.com/2017/07/14/how-to-handle-a-web-table-in-selenium-webdriver/");
        System.out.println("======================================== WEB TABLE DETAILS ========================================");
        List<WebElement> all_elements = webDriver.findElements(By.xpath("//*[@name='BookTable']//tr"));
        System.out.println("Total rows: " + all_elements.size());
        int counter = 1;
        for (WebElement each : all_elements){
            String xpath_value = "//*[@name='BookTable']//tr" + "[" +counter+ "]" + "//td";
            //System.out.println(xpath_value);
            List<WebElement> inside_values = each.findElements(By.xpath(xpath_value));
            for(WebElement value : inside_values){
                System.out.print(value.getText() + " | ");
            }
            System.out.println(" ");
            counter++;

        }


        System.out.println("======================================== Print the header ========================================");
        List<WebElement> headers = webDriver.findElements(By.xpath("//*[@name='BookTable']//tr//th"));
        System.out.println("Total header value: " + headers.size());
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

        webDriver.findElement(By.xpath("//a[@id='fancybox_ns-close']")).click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        webDriver.get("http://makeseleniumeasy.com/2017/07/14/how-to-handle-a-web-table-in-selenium-webdriver/");
        System.out.println("======================================== LAST COLUMN DETAILS ========================================");
        List<WebElement> all_elements = webDriver.findElements(By.xpath("//*[@name='BookTable']//tr[last()]//td"));
        for(WebElement element : all_elements){
            System.out.print(element.getText() + " | ");
        }

        //get the data of a column
        List<WebElement> column_all = webDriver.findElements(By.xpath("//*[@name='BookTable']//tr//td[1]"));
        for(WebElement value : column_all){
            System.out.println(value.getText());
        }

        }



    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
