package com.siwuxie095.foryou.exceptiondemo.example9;

/**
 * 自定义异常
 *
 * @author Jiajing Li
 * @date 2019-10-25 17:35:33
 */
public class ExceptionDemo {


    public static void main(String[] args) throws CustomizedCheckedException {

        nullPointer();
        arithmetic();

        System.out.println();
        System.out.println("最后，执行成功！！！");

    }


    private static void nullPointer() {
        try {
            System.out.println("String str = null;");
            String str = null;
            System.out.println("str 的长度：" + str.length());
        } catch (Exception e) {
            System.out.println("nullPointer 中产生了异常，抛出该异常");
            throw new CustomizedUncheckedException("产生了自定义的非检查异常");
        }
    }

    private static void arithmetic() throws CustomizedCheckedException {
        try {
            System.out.println("int i = 10 / 0;");
            int i = 10 / 0;
            System.out.println(i);
        } catch (Exception e) {
            System.out.println("arithmetic 中产生了异常，抛出该异常");
            throw new CustomizedCheckedException("产生了自定义的检查异常");
        }

    }

}
