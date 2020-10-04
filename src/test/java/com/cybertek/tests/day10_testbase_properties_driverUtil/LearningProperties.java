package com.cybertek.tests.day10_testbase_properties_driverUtil;

import org.testng.annotations.Test;

public class LearningProperties {


    @Test
    public void java_properties_test(){
        System.out.println("System.getProperty(\"os name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));

        //MAPS
        // Properties are stored in "key" and "value" format
        //key=value
        //os.name = Mac OS X
        //user.name = yonasmesfin
        //keys has to be exactly the same value when you pass it
        //otherwise it will not work. so if you are getting 'null' make sure your key is correct

    }

}
