package com.gouyanzhan.company;

import org.junit.Test;

public class Main {

    public static void main(String[] args) {
        printHelloWorld();
    }

    /**
     * 打印 Hello World
     */
    public static void printHelloWorld(){
        System.out.println("Hello World");
    }

    @Test
    public void testPrintHelloWorld() {
        printHelloWorld();
    }
}
