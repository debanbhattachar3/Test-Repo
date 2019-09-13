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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultiDropDown {
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
        webDriver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
    }

    @Test
    public void test1() {

        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@id='iframeResult']")));
        WebElement new_dropdown = webDriver.findElement(By.xpath("//select[@name='cars']"));
        Select select = new Select(new_dropdown);

        //select by index
        System.out.println("Is drop down list multi selected? " + select.isMultiple());
        select.selectByIndex(0);
        select.selectByIndex(1);


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        select.selectByValue("audi");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        select.deselectByValue("saab");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for (WebElement webElement : selectedOptions) {
            System.out.println(webElement.getText());
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        select.deselectAll();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterMethod
    public void afterMethod() {
        webDriver.close();
    }

}
