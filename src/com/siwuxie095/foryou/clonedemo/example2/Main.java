package com.siwuxie095.foryou.clonedemo.example2;

/**
 * @author Jiajing Li
 * @date 2019-10-09 08:56:20
 */
public class Main {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("Jack");
        user.setAge(20);
        user.setAddress("China");
        System.out.println("Jack's info: " + user);

        System.out.println();
        User user0 = user.clone();
        user0.setName("Tom");
        System.out.println("Tom's info: " + user0);
        System.out.println("Jack's info: " + user);
    }

}
