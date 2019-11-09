package com.siwuxie095.forme.designpattern.category.chapter11th.example3rd;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 糖果机
 *
 * @author Jiajing Li
 * @date 2019-11-08 21:11:08
 */
class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    /**
     * 糖果机地点
     */
    private String location;

    /**
     * 糖果数量
     */
    private int count;

    public GumballMachine(String location, int count) throws RemoteException {
        this.location = location;
        this.count = count;
    }

    public GumballMachine() throws RemoteException {
    }

    @Override
    public String getLocation() throws RemoteException {
        return location;
    }

    @Override
    public int getCount() throws RemoteException {
        return count;
    }
}
