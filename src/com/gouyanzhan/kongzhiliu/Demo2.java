package com.gouyanzhan.kongzhiliu;

import org.junit.Test;

public class Demo2 {
    public static void main(String[] args) {
        int k = 5;
        convertNumberToChinese(k);
    }

    /**
     * 数字对应的汉字
     * @param k 数字
     */
    private static void convertNumberToChinese(int k){
        String str = "k=" + k + "的汉字形式是：";
        //switch语句的使用
        switch (k) {
            case 1:
                str += "一";
                break;
            case 2:
                str += "二";
                break;
            case 3:
                str += "三";
                break;
            case 4:
                str += "四";
                break;
            case 5:
                str += "五";
                break;
            case 6:
                str += "六";
                break;
            case 7:
                str += "七";
                break;
            case 8:
                str += "八";
                break;
            case 9:
                str += "九";
                break;
            case 0:
                str += "零";
                break;
            default:
                str = "数字没有在1-10之间";
                break;
        }
        System.out.println(str);
    }

    @Test
    public void testConvertNumberToChinese(){
        int k = 4;
        convertNumberToChinese(k);
        k = -2;
        convertNumberToChinese(k);
        k = 100;
        convertNumberToChinese(k);
    }
}
