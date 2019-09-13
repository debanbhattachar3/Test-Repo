package com.debanjan.webdriver1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getTextValueTest {

    WebDriver webDriver = null;

    @Test
    public void test1() {
        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");

        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();

        //open URL
        webDriver.get("https://auth.geeksforgeeks.org");

        //text for the hyperlink
        WebElement hyperlink = webDriver.findElement(By.xpath("//a[contains(text(),'Why Create an Account?')]"));
        String hyperlink_Value = hyperlink.getText();
        System.out.println("Hyper link value: " + hyperlink_Value);
        Assert.assertEquals(hyperlink_Value, "Why Create an Account?");

        //text for button
        WebElement button = webDriver.findElement(By.xpath("//button[@class='btn btn-green signin-button']"));
        String button_text = button.getText();
        System.out.println("Button text value : " + button_text);
        Assert.assertEquals(button_text, "Sign In");

        //text for place holder
        WebElement passwordField = webDriver.findElement(By.xpath("//input[@id='password']"));
        String placeholder_text = passwordField.getAttribute("placeholder");
        System.out.println("Placeholder text : " + placeholder_text);
        Assert.assertEquals(placeholder_text, "Password");

        //normal text value
        WebElement textField = webDriver.findElement(By.xpath("//label[@class='modal-form-label']"));
        String textFieldValue = textField.getText();
        System.out.println("text field value: " + textFieldValue);
        Assert.assertEquals(textFieldValue, "Remember me");

        webDriver.quit();

    }
}
