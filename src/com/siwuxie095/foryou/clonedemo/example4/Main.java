package com.siwuxie095.foryou.clonedemo.example4;

/**
 * @author Jiajing Li
 * @date 2019-10-09 09:44:43
 */
public class Main {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("Jack");
        user.setAge(20);

        Address address = new Address();
        address.setCountry("China");
        address.setProvince("Shanghai");
        address.setCity("Shanghai");
        user.setAddress(address);
        System.out.println("Jack's info: " + user);

        System.out.println();
        User user0 = user.clone();
        user0.setName("Tom");
        System.out.println("Tom's info: " + user0);
        System.out.println("Jack's info: " + user);

        System.out.println();
        user0.getAddress().setProvince("Hubei");
        user0.getAddress().setCity("Wuhan");
        System.out.println("Tom's info: " + user0);
        System.out.println("Jack's info: " + user);
    }

}
