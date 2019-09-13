package com.debanjan.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWaitClass {

    WebDriver webDriver = null;

    @BeforeTest
    public void setUp() {
        String driver_path = System.getProperty("user.dir") + "/src/drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driver_path);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");

        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();


        //open google and search
        webDriver.get("file:///C:/Users/debanbhattachar3/Downloads/ExplicitWait.html");
    }

    @Test
    public void verifyAlert() {
        WebElement alertBtn = webDriver.findElement(By.xpath("//button[@id='alert']"));
        //click on the alert button
        alertBtn.click();

        //put explicit wait of 20 seconds
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 20);
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        //accept the alert
        webDriver.switchTo().alert().accept();
    }

    @Test
    public void verifyButtonEnable() {
        WebElement displayBtn = webDriver.findElement(By.xpath("//button[@id='display-other-button']"));
        displayBtn.click();

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 9);
        WebElement newBtn = webDriver.findElement(By.xpath("//button[contains(text(),'Enabled')]"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newBtn));
    }

    @Test
    public void verifyCheckBoxSelected() {
        WebElement checkboxBtn = webDriver.findElement(By.xpath("//button[@id='checkbox']"));
        WebElement checkBox = webDriver.findElement(By.xpath("//input[@id='ch']"));
        //click on the check box button
        checkboxBtn.click();

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 20);
        webDriverWait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@id='ch']")));

        Assert.assertTrue(checkBox.isSelected());
    }

    @Test
    public void verifyTestToBePresent() {
        WebElement textClick = webDriver.findElement(By.xpath("//button[@id='populate-text']"));
        //click on the button to change the text
        textClick.click();

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 20);

        //This will check the text is present on the element
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@class='target-text']"), "Selenium Webdriver"));

        //This will check the value attribute
        //webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//h2[@class='target-text']"), "Selenium Webdriver"));
    }

    @Test
    public void visibilityOfElementTest(){
        WebElement otherBtn = webDriver.findElement(By.xpath("//button[@id='display-other-button']"));
        //click on the button and wait for the 10 seconds to be displayed
        WebElement newBtn = webDriver.findElement(By.xpath("//button[contains(text(),'Enabled')]"));
        otherBtn.click();

        WebDriverWait webDriverWait = new WebDriverWait(webDriver,20);
        webDriverWait.until(ExpectedConditions.visibilityOf(newBtn));
    }

    @AfterTest
    public void tearDown() {
        //quit the driver
        webDriver.quit();
    }
}
