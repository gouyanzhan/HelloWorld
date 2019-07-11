package com.gouyanzhan.assignment.assign001;

/**
 * @author Yanzhan Gou
 * @date 2019-05-21 16:06:26
 */
public class Guess {
    private int num = 100;
    int a;
    public void check(int a){
        if (a > num){
            System.out.println("您猜的数字太大了");
        }else if (a < num) {
            System.out.println("您猜的数字太小了");
        }else{
            System.out.println("恭喜您！猜对了～");

        }
    }


}

//6、类的成员变量 猜数字游戏一个类Guess有一个成员变量num有一个初值100。定义一个类对Guess类的成员变量num进行猜。如果大了则提示大了小了则提示小了。等于则提示猜测成功