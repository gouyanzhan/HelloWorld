package com.gouyanzhan.shuzu;

public class ArrayDefaultVallue {

    private static String allType = "all";

    private static String byteType = "byte";

    private static String charType = "char";

    private static String longType = "long";

    private static String floatType = "float";

    private static String doubleType = "double";

    private static String stringType = "String";

    public static void main(String[] args) {
        printArrayDefaultValue(byteType);
        System.out.println();
        printArrayDefaultValue(allType);
    }

    private static void printArrayDefaultValue(String type) {
        // 创建一个byte类型的数组
        byte[] byteArray = new byte[1];
        // 创建一个char类型的数组
        char[] charArray = new char[1];
        // 创建一个long类型的数组
        long[] longArray = new long[1];
        // 创建一个float类型的数组
        float[] floatArray = new float[1];
        // 创建一个double类型的数组
        double[] doubleArray = new double[1];
        // 创建一个String类型的数组
        String[] stringArray = new String[1];
        // 打印出各个数组的默认初始值
        if (type.equals(byteType) || type.equals(allType)) {
            System.out.println("byte = " + byteArray[0]);
        }
        if (type.equals(charType) || type.equals(allType)) {
            System.out.println("char = " + charArray[0]);
        }
        if (type.equals(longType) || type.equals(allType)) {
            System.out.println("long = " + longArray[0]);
        }
        if (type.equals(floatType) || type.equals(allType)) {
            System.out.println("float = " + floatArray[0]);
        }
        if (type.equals(doubleType) || type.equals(allType)) {
            System.out.println("double = " + doubleArray[0]);
        }
        if (type.equals(stringType) || type.equals(allType)) {
            System.out.println("String = " + stringArray[0]);
        }
    }

}
