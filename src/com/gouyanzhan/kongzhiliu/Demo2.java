package com.gouyanzhan.kongzhiliu;

public class Demo2 {
    public static void main(String[]args) {
        int k = 5;
        String str = "k="+k+"的汉字形式是：";
        //switch语句的使用
        switch(k){
            case 1:
                str+="一";
                break;
            case 2:
                str+="二";
                break;
            case 3:
                str+="三";
                break;
            case 4:
                str+="四";
                break;
            case 5:
                str+="五";
                break;
            case 6:
                str+="六";
                break;
            case 7:
                str+="七";
                break;
            case 8:
                str+="八";
                break;
            case 9:
                str+="九";
                break;
            case 0:
                str+="零";
                break;
            default:
                str = "数字超出10";
                break;
        }
        System.out.println(str);

    }
}
