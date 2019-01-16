package com.gouyanzhan.exercise;

public class ZiFu {
    public static void main(String[] args) {
        printCharacter();
    }

    private static void printCharacter() {
        char a = 'A';
        System.out.println("第一个字符类型的值等于 " + a);
        char b = '\u003a';
        System.out.println("第二个字符类型的值等于 " + b);
        System.out.println("Hello \n World");
        System.out.println("Hello \\n World");
    }
}
