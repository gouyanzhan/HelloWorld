package com.siwuxie095.forme.test.test005;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2019-01-28 14:27:10
 */
public class Main {

    /**
     * 说明的问题：
     *
     * 测试 double 的精度问题。
     */

    public static void main(String[] args) {
        demo(5);
    }

    public static void demo(int n) {


        List<Double> valList = new ArrayList<>();

        int tempA = n;
        int tempB = n;

        while (tempA > 1) {
            double temp = 1.0 * (tempA - 1) / tempA;
            valList.add(temp);
            tempA--;
        }
        System.out.println("--------");
        System.out.println(valList);
        System.out.println("--------\n");

        while (tempB > 1) {
            double val = valList.remove(0);

            while (val > 0) {
                System.out.print(val);
                System.out.print(" ");
                double temp = 1.0 * 1 / tempB;
                val = val - temp;
            }

            System.out.println("\n");
            tempB--;
        }
    }
}
