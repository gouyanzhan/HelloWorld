package com.gouyanzhan.kongzhiliu;

import org.junit.Test;

public class Demo1 {
    public static void main(String[] args) {
        //用k表示成绩
        int k = 87;
        judgeScore(k);
        }

    /**
     *判断分数并打印结果
     * @param k 分数
     */
    private static void judgeScore(int k){
        //用str存放成绩评价
        String str;
        if (k < 0 | k > 100) {
            str = "成绩不合法";
        } else if (k < 60) {
            str = "成绩不及格";
        } else if (k >= 60 & k < 75) {
            str = "成绩合格";
        } else if (k >= 75 & k < 85) {
            str = "成绩良好";
        } else {
            str = "成绩优秀";
        }
        System.out.println("分数：" + k +" "+ str);
    }

    @Test
    public void testJudgeScore(){
        int k = -1;
        judgeScore(k);
        k = 59;
        judgeScore(k);
        k = 61;
        judgeScore(k);
        k = 75;
        judgeScore(k);
        k = 100;
        judgeScore(k);
        k = 200;
        judgeScore(k);
    }
}
