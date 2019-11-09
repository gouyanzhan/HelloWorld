package com.siwuxie095.forme.designpattern.category.chapter11th.example2nd;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 远程接口的实现
 *
 * @author Jiajing Li
 * @date 2019-11-08 19:16:41
 */
class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    MyRemoteImpl() throws RemoteException {}

    @Override
    public String sayHello() throws RemoteException {
        return "MyRemoteImpl # Hello";
    }

    public static void main(String[] args) {
        try {
            /*
             * 为你的服务命名，好让客户用来在注册表中寻找它，并在 RMI Registry 中
             * 注册此名字和此服务。当你绑定服务对象时，RMI 会把服务换成 Stub，然后
             * 把 Stub 放到 Registry 中。
             */
            MyRemote myRemote = new MyRemoteImpl();
            Naming.rebind("RemoteHello", myRemote);
        } catch (Exception e) {}
    }
}
