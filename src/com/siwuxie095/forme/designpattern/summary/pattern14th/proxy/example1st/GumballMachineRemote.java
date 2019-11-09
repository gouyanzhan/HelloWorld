package com.siwuxie095.forme.designpattern.summary.pattern14th.proxy.example1st;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 糖果机远程接口
 *
 * @author Jiajing Li
 * @date 2019-11-09 11:55:29
 */
interface GumballMachineRemote extends Remote {

    String getLocation() throws RemoteException;

    int getCount() throws RemoteException;

}
