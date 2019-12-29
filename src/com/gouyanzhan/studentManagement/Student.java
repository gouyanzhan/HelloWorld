package com.gouyanzhan.studentManagement;

/**
 * @author Yanzhan Gou
 * @date 2019-11-12 15:47:34
 */
public class Student {
    private int id;
    private String num;
    private String name;
    private String sex;
    private int age;
    private String email;
    private String classx;
    private String requiredCourses;
    private String electiveCourses;
    private String headTeacher;
    public Student(){
        super();
        this.num = num;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.classx = classx;
        this.requiredCourses = requiredCourses;
        this.electiveCourses = electiveCourses;
        this.headTeacher = headTeacher;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNum(){
        return num;
    }
    public void setNum(String num){
        this.num = num;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getClassx(){
        return classx;
    }
    public void setClassx(String classx){
        this.classx = classx;
    }
    public String getRequiredCourses(){
        return requiredCourses;
    }
    public void setRequiredCourses(String requiredCourses){
        this.requiredCourses = requiredCourses;
    }
    public String getElectiveCourses(){
        return electiveCourses;
    }
    public void setElectiveCourses(String electiveCourses){
        this.requiredCourses = requiredCourses;
    }
    public String getHeadTeacher(){
        return headTeacher;
    }
    public void setHeadTeacher(String headTeacher){
        this.headTeacher = headTeacher;
    }

}
