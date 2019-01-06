package com.gouyanzhan.kongzhiliu;

public class Demo12 {
    public static void main(String[] args) {
        //带标记的语句块
        first:{
              second:{
                  third:{
                        for(int i = 0;i<5;i++){
                            System.out.println("third:"+i);
                            //当n等于2的时候跳出语句块second
                            if (i==2)
                                break second;
                        }
                  }
                  System.out.println("在second语句块中");

        }
        System.out.println("在first语句块中");
        }

    }
}
