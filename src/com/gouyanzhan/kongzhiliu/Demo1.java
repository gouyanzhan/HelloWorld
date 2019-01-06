package com.gouyanzhan.kongzhiliu;

public class Demo1 {
    public static void main(String[]args){
        int k = 87;  //用k表示成绩
        String str = null;  //用str存放成绩评价
        if(k<0|k>100)
            str = "成绩不合法";
        else if (k<60)
            str = "成绩不及格";
        else if (k>=60&k<75)
            str = "成绩合格";
        else if (k>=75&k<85)
            str = "成绩良好";
        else
            str = "成绩优秀";
        System.out.println("分数："+k+str);
    }
}
