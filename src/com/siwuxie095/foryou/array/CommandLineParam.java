package com.siwuxie095.foryou.array;


import org.junit.Test;

/**
 * 命令行参数
 */
public class CommandLineParam {

    public static void main(String[] args) {
        printArgs(args);
    }

    private static void printArgs(String[] args) {
        System.out.println("参数长度：" + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数是：" + args[i]);
        }
    }

    @Test
    public void testPrintArgs() {
        String[] args = new String[5];
        args[0] = "abc";
        args[1] = 1 + "";
        printArgs(args);
    }
}
