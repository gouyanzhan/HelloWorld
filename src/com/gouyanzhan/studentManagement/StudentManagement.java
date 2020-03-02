package com.gouyanzhan.studentManagement;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Yanzhan Gou
 * @date 2019-11-12 16:07:14
 */
public class StudentManagement {
    public static void main(String[] args){
        ArrayList<Student> arry = new ArrayList<>();
        while(true){
            System.out.println("学生管理系统");
            System.out.println("1.查看所有学生信息");
            System.out.println("2.增加学生");
            System.out.println("3.删除学生");
            System.out.println("4.更改学生");
            System.out.println("5.退出系统");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入序号选择相应的功能：");
            String stufunction = sc.nextLine();
            switch (stufunction){
                case"1":
                    findstudent(arry);
                    break;
                case"2":
                    addStudent(arry);
                    break;
                case"3":
                    deleteStudent(arry);
                    break;
                case"4":
                    changeStudent(arry);
                    break;
                case"5":
                   default:
                       System.out.println("谢谢您的使用");
                       System.out.println(0);
                       break;
            }
        }
    }
    public static void findstudent(ArrayList<Student> arry){
        if (arry.size() == 0){
            System.out.println("不好意思，目前还没有学生的信息可供查询");
            return;
        }
        System.out.println("id\t\t\t学号\t\t\t姓名\t\t\t姓别\t\t\t年龄\t\t\temail\t\t\t年级\t\t\t必修课程\t\t\t选修课程");
        for (int i = 0;i < arry.size(); i++){
            Student s = arry.get(i);
            System.out.println(s.getId()+"\t\t\t"+s.getNum()+"\t\t\t"+s.getName()+"\t\t\t"+s.getSex()+"\t\t\t"+s.getAge()+"\t\t\t"+s.getEmail()+"\t\t\t"+s.getClassx()+"\t\t\t"+s.getRequiredCourses()+"\t\t\t"+s.getElectiveCourses()+"\t\t\t"+s.getHeadTeacher());

        }
    }
    public static void addStudent(ArrayList<Student> arry){
        Scanner sc = new Scanner(System.in);
        String num;
        while(true){
            System.out.println("请输入学号：");
            num = sc.nextLine();
            boolean flag = false;
            for (int i = 0;i < arry.size();i++){
                Student s = arry.get(i);
                if (s.getNum().equals(num)){
                    flag = true;
                    break;
                }
            }
            if (flag){
                System.out.println("您输入的账号被占用！！！");
            }else{
                break;
            }
        }
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        System.out.println("请输入性别：");
        String sex = sc.nextLine();
        System.out.println("请输入年龄：");
        Integer age =sc.nextInt();
        System.out.println("请输入email：");
        String email = sc.nextLine();
        System.out.println("请输入班级：");
        String classx = sc.nextLine();
        System.out.println("请输入必修课程：");
        String requiredCourses = sc.nextLine();
        System.out.println("请输入选修课程：");
        String electiveCourses = sc.nextLine();
        System.out.println("请输入班主任：");
        String headTeacher = sc.nextLine();
        Student s = new Student();
        s.setNum(num);
        s.setName(name);
        s.setSex(sex);
        s.setAge(age);
        s.setEmail(email);
        s.setClassx(classx);
        s.setRequiredCourses(requiredCourses);
        s.setElectiveCourses(electiveCourses);
        s.setHeadTeacher(headTeacher);
        arry.add(s);
        System.out.println("添加学生成功");
  }
  //删除类
    public static void  deleteStudent(ArrayList<Student> arry){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学号：");
        String deleNum = sc.nextLine();
        int index = -1;
        for (int i = 0; i <arry.size();i++){
            Student s = arry.get(i);
            if (s.getNum().equals(deleNum)){
                index = i;
            }
            if (index == -1){
                System.out.println("你要删除的学生不存在，请重新选择！");
            }else{
                arry.remove(index);
                System.out.println("删除学生成功！！");
            }
        }
    }
    //修改类
    public static void changeStudent(ArrayList<Student> arry){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要改变的学号：");
        String changNum = sc.nextLine();
        int index = -1;
        for (int i = 0;i < arry.size();i++){
            Student s = arry.get(i);
            if (s.getNum().equals(changNum)){
                index = i;
            }
        }
        if (index == -1){
            System.out.println("您要改变的学生不存在，请重新操作！");
        }else{
            System.out.println("请输入新姓名：");
            String name = sc.nextLine();
            System.out.println("请输入姓别：");
            String sex = sc.nextLine();
            System.out.println("请输入年龄：");
            Integer age =sc.nextInt();
            System.out.println("请输入email：");
            String email = sc.nextLine();
            System.out.println("请输入班级：");
            String classx = sc.nextLine();
            System.out.println("请输入必修课程：");
            String requiredCourses = sc.nextLine();
            System.out.println("请输入选修课程：");
            String electiveCourses = sc.nextLine();
            System.out.println("请输入班主任：");
            String headTeacher = sc.nextLine();
            //创建学生对象
            Student s = new Student();
            s.setNum(changNum);
            s.setName(name);
            s.setSex(sex);
            s.setAge(age);
            s.setEmail(email);
            s.setClassx(classx);
            s.setRequiredCourses(requiredCourses);
            s.setElectiveCourses(electiveCourses);
            s.setHeadTeacher(headTeacher);
            //修改学生对象
            arry.set(index,s);
            System.out.println("修改学生成功！！！");
        }
    }
}
