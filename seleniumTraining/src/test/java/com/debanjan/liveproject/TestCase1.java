package com.debanjan.liveproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestCase1 {
    WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void loginTest() {
        webDriver.get("https://www.rediff.com/");
        //click on the Money icon
        webDriver.findElement(By.xpath("//a[@class='moneyicon relative']")).click();
        webDriver.findElement(By.linkText("Sign In")).click();

        //Enter the email id and password
        webDriver.findElement(By.id("useremail")).sendKeys("debanjan1010@rediffmail.com");
        webDriver.findElement(By.xpath("//input[@id='emailsubmit'][@name='emailsubmit']")).click();

        //wait for the password field
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("userpass"))));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userpass")));

        webDriver.findElement(By.id("userpass")).sendKeys("Mahua@123");

        System.out.println(webDriver.findElement(By.id("userpass")).isDisplayed());
        System.out.println(webDriver.findElement(By.id("userpass")).isSelected());

        //Click on the Continue button
        webDriver.findElement(By.id("loginsubmit")).click();

        //Check if login is success   [contains(text(),'Debanjan Bhattacharya')]


//
//        WebElement welcome = webDriver.findElement(By.xpath("//span[@id='username']/a"));
//        welcome.isDisplayed();
//        System.out.println(welcome.getText());


        //wait to see the test in browser
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2, enabled = false)
    public void createPortfolio() {
        WebElement createBtn = webDriver.findElement(By.xpath("//a[@id='createPortfolio']"));
        createBtn.click();
        webDriver.findElement(By.id("create")).clear();
        webDriver.findElement(By.id("create")).sendKeys("TestPortfolio4");
        //click on the create button
        webDriver.findElement(By.xpath("//input[@id='createPortfolioButton']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3, enabled = false)
    public void testPortfolioName() {
        WebElement selectOption = webDriver.findElement(By.xpath("//select[@id='portfolioid']"));
        Select select = new Select(selectOption);
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, "TestPortfolio4", "Value doesn't match!");
    }

    @Test(priority = 4, enabled = false)
    public void addStockTest() {
        webDriver.findElement(By.id("addStock")).click();
        //enter the details
        webDriver.findElement(By.id("addstockname")).sendKeys("Ne");
        //select value from ajax call
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath("//div[@id='ajax_listOfOptions']/div[5]")).click();

        //set the date
        webDriver.findElement(By.xpath("//a[@class='calender floatR']")).click();
        pickDate("13-08-2017");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webDriver.findElement(By.id("addstockqty")).sendKeys("100");
        webDriver.findElement(By.id("addstockprice")).sendKeys("150");

        webDriver.findElement(By.id("addStockButton")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterSuite
    public void quitBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public void pickDate(String date) {
        Date datenow = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date expectedDate = simpleDateFormat.parse(date);

            String day = new SimpleDateFormat("dd").format(expectedDate);
            String month = new SimpleDateFormat("MMMM").format(expectedDate);
            String year = new SimpleDateFormat("yyyy").format(expectedDate);

            String month_year = month + " " + year;
            System.out.println(month_year);

            while (true) {
                String displayDate = webDriver.findElement(By.xpath("//div[@class='dpTitleText']")).getText();
                if (month_year.equals(displayDate)) {
                    webDriver.findElement(By.xpath("//td[@class='dpTD'][contains(text(),"+day+")]")).click();
                    break;
                } else if (expectedDate.compareTo(datenow) > 0) {
                    webDriver.findElement(By.xpath("//td[@class='dpButtonTD'][3]/button")).click();
                } else {
                    webDriver.findElement(By.xpath("//td[@class='dpButtonTD'][2]/button")).click();
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }


    @Test(priority = 5 , enabled = false)
    public void verifyStock(){
        int rows = webDriver.findElements(By.xpath("//table[@id='stock']//tr")).size();
        System.out.println("Total rows : " + rows);
        List<WebElement> row_element = webDriver.findElements(By.xpath("//table[@id='stock']//tr"));
        int row_number = 1;
        for(WebElement row : row_element){
            List<WebElement> columnsValues = webDriver.findElements(By.xpath("//table[@id='stock']//tr["+row_number+"]//td"));
            for(WebElement column_value : columnsValues){
                System.out.println(column_value.getText());
            }
            row_number++;
        }

        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(3,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

    }
}
