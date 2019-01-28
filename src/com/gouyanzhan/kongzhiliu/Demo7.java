package com.gouyanzhan.kongzhiliu;

public class Demo7 {
    public static void main(String[] args) {
        //和
        int n = 0;
        summation(n);
        summation1(n);
    }

    /**
     * 累加求和
     *
     * @param num
     */
    private static void summation(int num) {
        boolean flag = checkNum(num);
        if (!flag) {
            return;
        }
        //循环控制变量
        int n;
        int sum = 0;
        //利用for循环求和
        for (n = num; n > 0; n--) {
            sum += n;
        }
        System.out.println("1到" + num + "的整数的和：" + sum);
    }

    private static void summation1(int num) {
        boolean flag = checkNum(num);
        if (!flag) {
            return;
        }
        //循环控制变量
        int n;
        int sum = 0;
        //利用for循环求和
        for (n = 0; n <= num; n++) {
            sum += n;
        }
        System.out.println("1到" + num + "的整数的和：" + sum);
    }

    private static boolean checkNum(int num) {
        if (num <= 0) {
            System.out.println("不能输入小于或等于0的数");
            return false;
        }
        return true;
    }
}
