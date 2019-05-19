package com.gouyanzhan.clazz;

/**
 * @author Yanzhan Gou
 * @date 2019-03-17 18:09:19
 */
public class Student {
    int id = 0;
    static int studentNum = 0;
    Student(int x){
        id = x;
        studentNum++;
    }
    public static void main(String []args){
        Student s1 = new Student(1000);
        Student s2 = new Student(1001);
        Student s3 = new Student(1002);
        Student s4 = new Student(1003);
        System.out.println("s1的学号：" + s1.id);
        System.out.println("s2的学号：" + s2.id);
        System.out.println("s3的学号：" + s3.id);
        System.out.println("s3的学号：" + s4.id);
        System.out.println("学生的数目：" + Student.studentNum);
    }


}
