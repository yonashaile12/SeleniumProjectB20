package com.cybertek.tests.day11_utils_review_actions;

import org.testng.annotations.Test;

public class SingletonPractices {
/*
if you run the whole class
First time call. Word Object is null. Assigning value to it now!
str1 = something
Word already has value
str1 = something
Word already has value
str1 = something


Word already has value
str1 = something
 */
    @Test
    public void singleton_test1(){
        /*
        First time call. Word Object is null. Assigning value to it now!
                str1 = something
         */
        String str1 = Singleton.getWord();
        System.out.println("str1 = "+ str1);


        String str2 = Singleton.getWord();
        System.out.println("str1 = "+ str2);
        /*
        Word already has value
        str2 = something
         */

        String str3 = Singleton.getWord();
        System.out.println("str1 = "+ str3);
        /*
        Word already has value
        str3 = something
         */
    }

    @Test
    public void singleton_test2(){
        String str4 = Singleton.getWord();
        System.out.println("str1 = "+ str4);
    }
}
