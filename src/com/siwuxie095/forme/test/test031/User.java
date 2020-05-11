package com.siwuxie095.forme.test.test031;

/**
 * @author Jiajing Li
 * @date 2020-05-11 17:48:16
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
