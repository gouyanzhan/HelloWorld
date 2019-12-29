package com.siwuxie095.forme.designpattern.category.chapter11th.example2nd;

import java.rmi.Naming;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-11-08 20:02:39
 */
class MyClient {

    public static void main(String[] args) {
        new MyClient().go();
    }

    void go() {
        try {
            MyRemote myRemote = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String result = myRemote.sayHello();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
