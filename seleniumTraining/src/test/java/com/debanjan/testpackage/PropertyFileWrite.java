package com.debanjan.testpackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileWrite {

    public Properties properties = new Properties();
    public FileOutputStream fileOutputStream = null;

    public void writePropertyFile() {
        try {
            fileOutputStream = new FileOutputStream("config.properties");
            properties.setProperty("db_address", "testDB");
            properties.setProperty("db_name", "test name");
            properties.setProperty("db_username", "admin");
            properties.setProperty("db_password", "password123");

            properties.store(fileOutputStream, "Entries For the DB details");
            System.out.println("DB details entry in configuration file");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    System.out.println("Configuration file closed.");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}
