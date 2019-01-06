package com.gouyanzhan.shuzu;

import org.junit.Test;

public class ArgsDemo {
    public static void main(String[] args) {
        printArgs(args);
    }

    /**
     * 打印接受到的参数
     *
     * @param args 接受到的参数
     */
    public static void printArgs(String[] args){
        System.out.println("共接受到"+args.length+"个参数");
        for (int i = 0;i <args.length;i++){
            System.out.println("第"+i+"个参数"+args[i]);
        }
    }

    @Test
    public void testPrintArgs(){
        String[] args = new String[3];
        args[0] = "a";
        args[1] = 1 + "";
        args[2] = "c";
        printArgs(args);
    }
}

