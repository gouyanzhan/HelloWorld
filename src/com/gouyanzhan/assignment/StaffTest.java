package com.gouyanzhan.assignment;

/**
 * @author Yanzhan Gou
 * @date 2019-05-19 11:41:20
 */
public class StaffTest {
    public static void main(String[] args){
        Staff z = new Staff();
        z.getName("张三");
        z.getAge(22);
        z.getNumber("A1001");
        z.getWage(10000);
        System.out.println("姓名："+z.getName("张三"));
        System.out.println("年龄："+z.getAge(22));
        System.out.println("编号："+z.getNumber("A1001"));
        System.out.println("工资："+z.getWage(10000));



    }


}
