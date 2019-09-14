package com.gouyanzhan.nine.example7;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 14:52:35
 */
class IllegaScoreException extends Exception{
    IllegaScoreException(){
    }
    IllegaScoreException(String msg){
        //调用父类的构造方法
        super(msg);
    }
}
public class Score {
    public static void main(String[] args){
        try {
            String level = null;
            level = scoreLevel(90);
            System.out.println("90分的成绩等级为：" + level);
            level = scoreLevel(120);
            System.out.println("120分的成绩等级为：" + level);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
    }
    static String scoreLevel(int score)throws IllegalAccessException{
        if (score >= 85 && score <=100){
            return "A";
        }
        else if (score >= 75 && score < 85){
            return "B";
        }
        else if (score >= 60 && score < 75){
            return "C";
        }
        else if (score < 60 && score >=0){
            return "D";
        }
        else{
            throw new IllegalAccessException("非法的分数");
        }
    }

}
