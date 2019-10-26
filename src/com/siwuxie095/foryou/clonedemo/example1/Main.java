package com.siwuxie095.foryou.clonedemo.example1;

/**
 * @author Jiajing Li
 * @date 2019-10-09 08:44:19
 */
public class Main {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("Jack");
        user.setAge(20);
        user.setAddress("China");
        System.out.println("Jack's info: " + user);
        //System.out.println("Jack's info: " + user.toString());

        System.out.println();
        User user0 = user;
        user0.setName("Tom");
        System.out.println("Tom's info: " + user0);
        System.out.println("Jack's info: " + user);

        User user1 = new User();
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        user1.setAddress(user.getAddress());

        user1.setName("Jim");

        //Integer i = 1;
        //System.out.println(i);
        //System.out.println(i.toString());
    }

}
