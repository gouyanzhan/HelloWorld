package com.siwuxie095.foryou.exceptiondemo.example8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 抛出异常（抛异常）：throw
 *
 * @author Jiajing Li
 * @date 2019-10-25 17:35:33
 */
public class ExceptionDemo {


    public static void main(String[] args) throws Exception {
        try {
            uncheckedEx();

            checkedEx();
        } catch (Exception e) {
            System.out.println("main 中的产生了异常");
            e.printStackTrace();
        }


        System.out.println();
        System.out.println("最后，执行成功！！！");

    }

    private static void uncheckedEx() throws NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException, Exception {
        //nullPointer();
        arithmetic();
        arrayIndexOutOfBounds();
    }

    private static void nullPointer() throws NullPointerException {
            System.out.println("String str = null;");
            String str = null;
            System.out.println("str 的长度：" + str.length());
    }

    private static void arithmetic() {
            try {
                System.out.println("int i = 10 / 0;");
                int i = 10 / 0;
                System.out.println(i);
            } catch (ArithmeticException e) {
                System.out.println("arithmetic 中产生了算术异常，无法打印。继续抛异常");
                //e.printStackTrace();
                throw e;
            } catch (Exception e) {
                System.out.println("arithmetic 中产生了异常，无法打印。继续抛异常");
                //e.printStackTrace();
                throw e;
            }
    }

    private static void arrayIndexOutOfBounds() throws ArrayIndexOutOfBoundsException {
        try {
            float[] arr = new float[] {1.0F, 2.0F, 3.0F};
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println(arr[2]);
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("arrayIndexOutOfBounds 中产生了数组越界异常，无法打印。继续抛异常");
            //e.printStackTrace();
            throw e;
        }
    }


    private static void checkedEx() throws FileNotFoundException {
            fileNotFound();
    }

    private static void fileNotFound() throws FileNotFoundException {
            File file = new File("123");
            FileInputStream fis = new FileInputStream(file);
    }

}
