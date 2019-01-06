package com.gouyanzhan.kongzhiliu;

import java.io.IOException;

public class Demo6 {
    public static void main(String[] args) throws IOException {
        char n = 0;  //定义一个字符变量
        do{          //使用do-while循环语句
            //打印出菜单
            System.out.println("1:选择1");
            System.out.println("2:选择2");
            System.out.println("3:选择3");
            System.out.println("4:选择4");
            System.out.println("5:选择5");
            System.out.println("请输入选择：");
            n = (char)System.in.read();  //将输入的内容转化为字符类型
            switch (n){
                case'1':   //判断用户输入的内容
                    System.out.println("选择1");
                    break;
                case'2':
                    System.out.println("选择2");
                    break;
                case'3':
                    System.out.println("选择3");
                    break;
                case'4':
                    System.out.println("选择4");
                    break;
                case'5':
                    System.out.println("选择5");
                    break;
                default:
                    System.out.println("输入非法");
                    break;
            }
        }while(n<'1'||n>'5');

    }
}
