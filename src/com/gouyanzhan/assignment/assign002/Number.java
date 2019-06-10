package com.gouyanzhan.assignment.assign002;

/**
 * @author Yanzhan Gou
 * @date 2019-06-10 20:49:11
 */
public class Number {
    private int n1;
    private int n2;
    int z;
    public Number(int n1,int n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    public void addition(){
        z = n1 + n2;
        System.out.println(z);
    }
    public void subtration(){
        z = n1 - n2;
        System.out.println(z);
    }
    public void multiplication(){
        z = n1 * n2;
        System.out.println(z);
    }
    public void division(){
        z = n1 / n2;
        System.out.println(z);
    }

}
