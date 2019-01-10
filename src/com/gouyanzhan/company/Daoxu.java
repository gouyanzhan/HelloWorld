package com.gouyanzhan.company;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Daoxu {
    public static void main(String[] args) {
      printReverseChar();
    }

    public static void printReverseChar(){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一串字母：");
        String str = scan.next();
        char[] charArray = str.toCharArray();
        System.out.println("逆序后的字母：");
        for (int i = charArray.length - 1; i >= 0; i--) {
            System.out.print(charArray[i]);
        }
    }

    /**
     * https://blog.csdn.net/pange1991/article/details/81135151
     * http://www.codes51.com/itwd/1196553.html
     * https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
     * https://stackoverflow.com/questions/10531465/capture-keyboard-input-in-junit-test
     */
    public static void printReverseCharForTest(){
        String data = "Hello, World!";
        String input;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入一串字母：");
            input = scan.next();
            System.out.println(input);
        } finally {
            System.setIn(stdin);
        }
        char[] charArray = input.toCharArray();
        System.out.println("逆序后的字母：");
        for (int i = charArray.length - 1; i >= 0; i--) {
            System.out.print(charArray[i]);
        }
    }



    @Test
    public void testPrintReverseCharForTest(){
        printReverseCharForTest();
    }


}

