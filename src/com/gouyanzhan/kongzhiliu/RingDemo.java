package com.gouyanzhan.kongzhiliu;

import java.io.*;

public class RingDemo {
    public static void main(String[] args) {
        String strln = "";
        System.out.println("请输入矩阵的行列数:");
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buff =new BufferedReader(input);
        try{
            strln = buff.readLine();
        }catch (IOException e){
            System.out.println(e.toString());
        }

        int int1 = Integer.parseInt(strln);
        int n = int1;
        System.out.println("这是行列数为"+n+"的螺线型数组");
        int intA =1;
        int[][] array = new int[n][n];
        int intB ;
        if (n%2!=0){
            intB = n/2 +1;  //奇数时i循环次数
        }else
            intB = n/2;   //偶数时i循环次数
        for (int i =0;i<intB;i++)
        {  //从外到里循环
            //从左到右横的开始
            for(int j =i;j<n-i;j++){
                array[i][j] = intA;
                intA++;
            }
            //从上到下纵
            for (int k =i+1;k<n-i;k++) {
                array[k][n - i - 1] = intA;
                intA++;
            }
           //从右到左横
            for (int l =n-i-2;l>i;l--){
                array[n-i-1][l]=intA;
                intA++;
            }
            //从下到上纵
            for (int m =n-i-2;m>i;m--){
                array[m][i]=intA;
                intA++;
            }

        }
        //输出数组
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }

            }
        }
