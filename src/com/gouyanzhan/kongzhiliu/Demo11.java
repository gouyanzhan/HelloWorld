package com.gouyanzhan.kongzhiliu;

public class Demo11 {
    public static void main(String[] args) {
        System.out.println("使用break的例子");
        //外循环for语句
        for(int k = 0;k<3;k++){
            System.out.println("第"+(++k)+"次外循环");  //使程序的输出结果表现为1，2，3
            k--;
            //内循环
            for (int i = 0;i<50;i++){
                System.out.println("内循环："+"i=" +i);
                if(i==3)
                    break;
            }
        }
        System.out.println("循环跳出" );

    }
}
