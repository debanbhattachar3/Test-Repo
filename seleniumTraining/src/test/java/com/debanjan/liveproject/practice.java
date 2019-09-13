package com.debanjan.liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class practice {

    WebDriver webDriver;


    @Test
    public void test1(){
        Select select = new Select(webDriver.findElement(By.xpath("")));
        select.getFirstSelectedOption();
        select.selectByIndex(1);

        //run js
        JavascriptExecutor javascriptExecutor =  (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("documents.readyState");
    }
}
