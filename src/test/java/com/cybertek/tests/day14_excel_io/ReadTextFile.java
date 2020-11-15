package com.cybertek.tests.day14_excel_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile {


    public static void main(String[] args) throws FileNotFoundException {
        String path = "shopping_list.txt";
        // file's constructor requires path to the file as an argument
        File file = new File(path);
        //check if file exist
        System.out.println(file.exists());
        // we can read lines of file with scanner class
        //System.in -for keyboard input
        // file object - for reading file
        Scanner scanner = new Scanner(file);

        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());

        while(scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
//          #########################################
        String path2 = "grades.csv";

        File file2 = new File(path2);

        Scanner scanner2 = new Scanner(file2);

        while(scanner2.hasNext()){
            System.out.println(scanner2.nextLine());
        }

    }
}
