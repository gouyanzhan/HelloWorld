package com.siwuxie095.forme.test.test030;

/**
 * @author Jiajing Li
 * @date 2020-04-29 11:03:47
 */
public class User {

    int id;

    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
