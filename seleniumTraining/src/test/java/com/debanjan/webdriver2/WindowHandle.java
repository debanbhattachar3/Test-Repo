package com.debanjan.webdriver2;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {

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

    }

    @Test
    public void test1() {
        //open URL
        webDriver.get("https://www.facebook.com");
        String windowID = webDriver.getWindowHandle();
        System.out.println("Window ID before clicking on the Sign Up button: " + windowID);

        WebElement signUp = webDriver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
        signUp.click();

        String windowID1 = webDriver.getWindowHandle();
        System.out.println("Window ID after clicking on the Sign Up button: " + windowID1);
        System.out.println("**********************************************************");

    }

    @Test
    public void test2() {
        //open URL
        webDriver.get("https://www.naukri.com");
        Set<String> windows = webDriver.getWindowHandles();
        System.out.println("Total window :  " + windows.size());
        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("**********************************************************");
    }

    @Test
    public void test3() {
        //open the URL and click
        webDriver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
        //change to the iframe
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@id='iframeResult']")));
        webDriver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']")).click();

        Set<String> windows = webDriver.getWindowHandles();
        System.out.println("Total window :  " + windows.size());
        Iterator<String> iterator = windows.iterator();
        String first_window_id = iterator.next();
        String second_window_id = iterator.next();


        //change the window handler
        webDriver.switchTo().window(second_window_id);

        webDriver.findElement(By.xpath("//a[@id='navbtn_tutorials']")).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }
}
