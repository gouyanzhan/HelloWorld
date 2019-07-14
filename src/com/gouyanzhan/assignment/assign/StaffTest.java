package com.gouyanzhan.assignment.assign;

/**
 * @author Yanzhan Gou
 * @date 2019-05-19 11:41:20
 */
public class StaffTest {
    public static void main(String[] args){
        Staff z = new Staff();

        System.out.println("姓名："+z.getName());
        System.out.println("年龄："+z.getAge());
        System.out.println("编号："+z.getNumber());
        System.out.println("工资："+z.getWage());

        z.setName("张三");
        z.setAge(22);
        z.setNumber("A1001");
        z.setWage(10000);

        System.out.println("姓名："+z.getName());
        System.out.println("年龄："+z.getAge());
        System.out.println("编号："+z.getNumber());
        System.out.println("工资："+z.getWage());



    }


}
