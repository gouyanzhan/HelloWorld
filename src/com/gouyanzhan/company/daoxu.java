package com.gouyanzhan.company;

import java.util.Scanner;

public class daoxu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一串字母：");
        String str = scan.next();
        char[]charArray = str.toCharArray();
        for (int i = charArray.length-1;i >= 0;i--){
            System.out.print(charArray[i]);
        }
        }

    }

