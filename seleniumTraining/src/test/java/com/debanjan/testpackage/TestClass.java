package com.debanjan.testpackage;

import org.testng.annotations.Test;

public class TestClass {

    //Test the property file
    PropertyFileWrite propertyFileWrite = new PropertyFileWrite();
    PropertyFileRead propertyFileRead = new PropertyFileRead();

    @Test(priority = 1)
    public void testPropertyFileWrite() {
        propertyFileWrite.writePropertyFile();
    }

    @Test(priority = 2)
    public void testPropertyFileRead(){
        propertyFileRead.propertyFileRead();
    }

}
