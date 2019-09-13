package com.debanjan.webdriver2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDrop {
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
        webDriver.get("https://jqueryui.com");
        webDriver.findElement(By.linkText("Draggable")).click();

        //move to the Iframe
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        //Perform drag and drop
        WebElement draggable_element = webDriver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(webDriver);
        actions.dragAndDropBy(draggable_element, 200, 150).build().perform();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        webDriver.get("https://jqueryui.com");
        webDriver.findElement(By.linkText("Droppable")).click();

        //move to the Iframe
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        WebElement source = webDriver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = webDriver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(webDriver);
        actions.dragAndDrop(source, target).build().perform();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test3() {
        webDriver.get("https://jqueryui.com");
        webDriver.findElement(By.linkText("Droppable")).click();

        //move to the Iframe
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        WebElement source = webDriver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = webDriver.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions = new Actions(webDriver);
        actions.clickAndHold(source).moveToElement(target).release().build().perform();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
