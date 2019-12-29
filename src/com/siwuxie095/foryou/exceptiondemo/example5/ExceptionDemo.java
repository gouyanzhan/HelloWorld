package com.siwuxie095.foryou.exceptiondemo.example5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 异常捕获：finally 的运用
 *
 * @author Jiajing Li
 * @date 2019-10-25 17:35:33
 */
public class ExceptionDemo {


    public static void main(String[] args) {

        uncheckedEx();

        checkedEx();

        System.out.println();
        System.out.println("最后，执行成功！！！");

    }

    private static void uncheckedEx() {
        try {
            nullPointer();
            arithmetic();
            arrayIndexOutOfBounds();
        }
        //catch (NullPointerException e) {
        //    System.out.println("uncheckedEx 中产生了空指针异常，无法打印");
        //    e.printStackTrace();
        //}
        catch (ArithmeticException e) {
            System.out.println("uncheckedEx 中产生了算术异常，无法打印");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("uncheckedEx 中产生了数组越界异常异常，无法打印");
            e.printStackTrace();
        }
        //catch (Exception e) {
        //    System.out.println("uncheckedEx 中产生了异常，无法打印");
        //    e.printStackTrace();
        //}
        finally {
            System.out.println("必然执行，即便报错");
        }
    }

    private static void nullPointer() {
            System.out.println("String str = null;");
            String str = null;
            System.out.println("str 的长度：" + str.length());
    }

    private static void arithmetic() {
            System.out.println("int i = 10 / 0;");
            int i = 10 / 0;
            System.out.println(i);
    }

    private static void arrayIndexOutOfBounds() {
            float[] arr = new float[] {1.0F, 2.0F, 3.0F};
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            System.out.println(arr[2]);
            System.out.println(arr[3]);
    }


    private static void checkedEx() {
        try {
            fileNotFound();
        }
        //catch (FileNotFoundException e) {
        //    System.out.println("checkedEx 中产生了找不到文件异常，无法打印");
        //    e.printStackTrace();
        //}
        catch (Exception e) {
            System.out.println("checkedEx 中产生了异常，无法打印");
            e.printStackTrace();
        }

    }

    private static void fileNotFound() {
        try {
            File file = new File("123");
            FileInputStream fis = new FileInputStream(file);
        } catch (NullPointerException e) {
            System.out.println("fileNotFound 中产生了空指针异常，无法打印");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("fileNotFound 中产生了找不到文件异常，无法打印");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("fileNotFound 中产生了异常，无法打印");
            e.printStackTrace();
        } finally {

        }

    }

}
