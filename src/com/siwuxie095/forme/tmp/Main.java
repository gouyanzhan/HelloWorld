package com.siwuxie095.forme.tmp;

import java.util.Scanner;

/**
 * @author Jiajing Li
 * @date 2020-03-03 10:35:43
 */
public class Main {
    /**
     * 读取这个页面的数据，做成配置：
     * https://docs.adyen.com/development-resources/currency-codes#page-introduction
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] arr = input.split(" ");
            String code = arr[0];
            String decimalPoints = arr[arr.length - 1];
            StringBuilder currency = new StringBuilder();
            for (int i = 1; i < arr.length - 1; i++) {
                currency.append(arr[i]);
                currency.append(" ");
            }

            System.out.println(code + "(\"" +code + "\", \"" + currency.toString().trim() + "\", " + decimalPoints + "),");
        }
    }

}
