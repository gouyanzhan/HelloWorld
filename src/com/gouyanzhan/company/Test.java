package com.gouyanzhan.company;

/**
 * 测试类
 *
 * @author Yanzhan Gou
 * @date 2019-01-08 22:45:51
 */
public class Test {
    public static void main(String[] args) {

    }

    /**
     * 有参数有返回值的方法
     *
     * @param arr 参数类型是int型的数组
     * @return 返回值类型是int型
     */
    public static int test_1(int[] arr) {
        //return 1;
        return arr[0];
    }

    /**
     * 有参数没有返回值的方法
     *
     * @param a 参数类型是char字符
     *          返回值类型是void，就是没有返回值
     */
    public static void test_2(char a) {
        //return;
    }

    /**
     * 没有参数有返回值的方法
     *
     * @return 返回值类型是string字符串类型
     */
    public static String test_3(){
        //String a ="h";
        //return a;
        return "h";
    }

    /**
     * 没有参数没有返回值的方法
     */
    public static void test_4(){

    }



}
