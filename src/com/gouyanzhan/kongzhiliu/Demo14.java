package com.gouyanzhan.kongzhiliu;

public class Demo14 {
    public static void main(String[] args) {
        for (int i = 1;i<51;i++){
            System.out.print(i+" ");
            if (i%5!=0)
                //当n不能整除5的时候继续进行循环
                continue;
            else
                System.out.println("*****");
        }

    }
}
