package com.siwuxie095.forme.designpattern.category.chapter11th.example2nd;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程接口
 *
 * 扩展自 java.rmi.Remote，表示此接口要用来支持远程调用。
 *
 * @author Jiajing Li
 * @date 2019-11-08 19:07:50
 */
interface MyRemote extends Remote {

    /**
     * 每次远程方法调用都必须考虑是 "有风险的"。在每个方法中声明
     * RemoteException，可以让客户注意到这件事，并了解这可能是
     * 无法工作的。
     */
    String sayHello() throws RemoteException;

}
