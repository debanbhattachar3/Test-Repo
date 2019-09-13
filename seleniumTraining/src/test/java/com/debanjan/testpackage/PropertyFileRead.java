package com.debanjan.testpackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileRead {

    public Properties properties = new Properties();
    public FileInputStream fileInputStream;

    public void propertyFileRead() {
        try {
            fileInputStream = new FileInputStream("config.properties");
            properties.load(fileInputStream);

            System.out.println(properties.getProperty("db_name"));
            System.out.println(properties.getProperty("db_address"));
            System.out.println(properties.getProperty("db_username"));
            System.out.println(properties.getProperty("db_password"));

            System.out.println("All property value is read");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    System.out.println("File is closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
