package com.siwuxie095.forme.util;

import com.alibaba.fastjson.JSON;

/**
 * 打印（输出到控制台）相关的工具类
 *
 * @author Jiajing Li
 * @date 2019-01-09 17:17:27
 */
public final class PrintX {

    private PrintX() {
        throw new AssertionError("There is no PrintX instance for you!");
    }

    ///**
    // * 将对象按照JSON格式打印出来
    // *
    // * @param object 对象（单个对象、List对象、Map对象等）
    // */
    //public static void printObjectAsJsonFormat(Object object) {
    //    String start = "丨  ";
    //    // 先将object对象转化为string对象
    //    String jsonStr = JSON.toJSONString(object);
    //    // 用户标记层级
    //    int level = 0;
    //    // 新建StringBuffer对象，用户接收转化好的String字符串
    //    StringBuilder builder = new StringBuilder();
    //    // 循环遍历每一个字符
    //    for (int i = 0; i < jsonStr.length(); i++) {
    //        // 获取当前字符
    //        char piece = jsonStr.charAt(i);
    //        // 如果上一个字符是断行，则在本行开始按照level数值添加标记符，排除第一行
    //        if (i != 0 && '\n' == builder.charAt(builder.length() - 1)) {
    //            for (int k = 0; k < level; k++) {
    //                builder.append(start);
    //            }
    //        }
    //        switch (piece) {
    //            case '{':
    //            case '[':
    //                // 如果字符是{或者[，则断行，level加1
    //                builder.append(piece + "\n");
    //                level++;
    //                break;
    //            case ',':
    //                // 如果是“,”，则断行
    //                builder.append(piece + "\n");
    //                break;
    //            case '}':
    //            case ']':
    //                // 如果是}或者]，则断行，level减1
    //                builder.append("\n");
    //                level--;
    //                for (int k = 0; k < level; k++) {
    //                    builder.append(start);
    //                }
    //                builder.append(piece);
    //                break;
    //            default:
    //                builder.append(piece);
    //                break;
    //        }
    //    }
    //    System.out.println(builder.toString());
    //}

    /**
     * 打印分割线
     */
    public static void printSplitLine() {
        System.out.println();
        System.out.println("_____ ||||| ***** ||||| +++++ ----- ||||| ----- +++++ ||||| ***** ||||| _____");
        System.out.println();
    }

    /**
     * 打印内容并换行
     *
     * @param obj 要打印的内容
     */
    public static void println(Object obj) {
        System.out.println(obj);
    }

    /**
     * 仅打印一个换行
     */
    public static void println() {
        System.out.println();
    }

    /**
     * 打印内容但不换行
     *
     * @param obj 要打印的内容
     */
    public static void print(Object obj) {
        System.out.print(obj);
    }

    /**
     * 格式化输出
     *
     * @param obj 要输出的内容
     */
    public static void printf(Object obj) {
        System.out.printf("%7s", obj);
    }


}
