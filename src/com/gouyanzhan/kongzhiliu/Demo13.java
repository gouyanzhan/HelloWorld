package com.gouyanzhan.kongzhiliu;

public class Demo13 {
    public static void main(String[] args) {
       useOutTagStatementBlock();
    }

    /**
     * 使用out标记语句块
     */
    private static void useOutTagStatementBlock(){
        //使用out标记语句块
        out:{
            for (int i = 0;i<20;i++){
                System.out.println("外循环"+i);
                for (int j = 0;j<20;j++){
                    System.out.println("内循环"+j);
                    if (j==10) {
                        //使用break语句跳出out语句块
                        break out;
                    }
                }
            }
        }
    }
}
