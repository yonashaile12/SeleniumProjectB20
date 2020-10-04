package com.cybertek.tests.day10_testbase_properties_driverUtil;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws IOException {

        // Properties: Use Properties class objects
        // We create properties object to be able to read configuration.properties file
        //import from java.util.Properties
        Properties properties = new Properties();

        // FileInputStream: opens the file
        //configuration.properties -->
        // configuration right click copy-->copyPath-->copy path content from root
        String path = "configuration.properties";

        //We need to pass the path of the file we want to open in JVM
        FileInputStream file = new FileInputStream(path);

        // We will loaf file
        properties.load(file);

        // We read from the file
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

        // Close the file
        file.close();
    }

}
