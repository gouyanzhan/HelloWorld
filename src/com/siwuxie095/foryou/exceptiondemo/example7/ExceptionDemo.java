package com.siwuxie095.foryou.exceptiondemo.example7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 异常上抛后再捕获
 *
 * @author Jiajing Li
 * @date 2019-10-25 17:35:33
 */
public class ExceptionDemo {


    public static void main(String[] args)
            //throws Exception
    {
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
        nullPointer();
        arithmetic();
        arrayIndexOutOfBounds();
    }

    private static void nullPointer() throws NullPointerException, Exception {
            System.out.println("String str = null;");
            String str = null;
            System.out.println("str 的长度：" + str.length());
    }

    private static void arithmetic() throws ArithmeticException {
            System.out.println("int i = 10 / 0;");
            int i = 10 / 0;
            System.out.println(i);
    }

    private static void arrayIndexOutOfBounds() throws ArrayIndexOutOfBoundsException {
            float[] arr = new float[] {1.0F, 2.0F, 3.0F};
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println(arr[2]);
            System.out.println(arr[3]);
    }


    private static void checkedEx() throws FileNotFoundException {
            fileNotFound();
    }

    private static void fileNotFound() throws FileNotFoundException {
            File file = new File("123");
            FileInputStream fis = new FileInputStream(file);
    }

}
